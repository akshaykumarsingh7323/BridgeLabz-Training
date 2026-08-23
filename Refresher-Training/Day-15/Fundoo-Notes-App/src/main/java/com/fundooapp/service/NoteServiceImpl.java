package com.fundooapp.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fundooapp.dto.NoteRequest;
import com.fundooapp.dto.NoteResponse;
import com.fundooapp.entity.Note;
import com.fundooapp.entity.Tag;
import com.fundooapp.entity.User;
import com.fundooapp.exception.NoteNotFoundException;
import com.fundooapp.exception.TagNotFoundException;
import com.fundooapp.exception.UserNotFoundException;
import com.fundooapp.repository.NoteRepository;
import com.fundooapp.repository.TagRepository;
import com.fundooapp.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

	private final NoteRepository noteRepository;

	private final UserRepository userRepository;

	private final TagRepository tagRepository;

	@Override
	public NoteResponse createNote(String email, NoteRequest request) {

		User user = getUserByEmail(email);

		Note note = new Note();

		note.setTitle(request.getTitle());

		note.setContent(request.getContent());

		note.setUser(user);

		LocalDateTime now = LocalDateTime.now();

		note.setCreatedAt(now);

		note.setUpdatedAt(now);

		Note savedNote = noteRepository.save(note);

		return convertToResponse(savedNote);
	}

	@Override
	public List<NoteResponse> getAllNotes(String email, Boolean pinned, Boolean archived, Boolean trashed) {

		User user = getUserByEmail(email);

		List<Note> notes = noteRepository.findNotesWithFilters(user, pinned, archived, trashed);

		return notes.stream().map(this::convertToResponse).toList();
	}

	@Override
	public NoteResponse getNoteById(Long id, String email) {

		User user = getUserByEmail(email);

		Note note = noteRepository.findByIdAndUser(id, user)
				.orElseThrow(() -> new NoteNotFoundException("Note not found with id: " + id));

		return convertToResponse(note);
	}

	@Override
	public NoteResponse updateNote(Long id, String email, NoteRequest request) {

		User user = getUserByEmail(email);

		Note note = noteRepository.findByIdAndUser(id, user)
				.orElseThrow(() -> new NoteNotFoundException("Note not found with id: " + id));

		note.setTitle(request.getTitle());

		note.setContent(request.getContent());

		note.setUpdatedAt(LocalDateTime.now());

		Note updatedNote = noteRepository.save(note);

		return convertToResponse(updatedNote);
	}

	@Override
	public void deleteNote(Long id, String email) {

		User user = getUserByEmail(email);

		Note note = noteRepository.findByIdAndUser(id, user)
				.orElseThrow(() -> new NoteNotFoundException("Note not found with id: " + id));

		noteRepository.delete(note);
	}

	private User getUserByEmail(String email) {

		return userRepository.findByEmail(email)
				.orElseThrow(() -> new UserNotFoundException("User not found with email: " + email));
	}

	private NoteResponse convertToResponse(Note note) {

		return new NoteResponse(note.getId(), note.getTitle(), note.getContent(), note.getCreatedAt(),
				note.getUpdatedAt(), note.isPinned(), note.isArchived(), note.isTrashed());
	}

	@Override
	public NoteResponse pinNote(Long id, String email) {

		User user = getUserByEmail(email);

		Note note = noteRepository.findByIdAndUser(id, user)
				.orElseThrow(() -> new NoteNotFoundException("Note not found with id " + id));

		note.setPinned(true);
		note.setUpdatedAt(LocalDateTime.now());

		Note savedNote = noteRepository.save(note);

		return convertToResponse(savedNote);
	}

	@Override
	public NoteResponse unpinNote(Long id, String email) {

		User user = getUserByEmail(email);

		Note note = noteRepository.findByIdAndUser(id, user)
				.orElseThrow(() -> new NoteNotFoundException("Note not found with id " + id));

		note.setPinned(false);
		note.setUpdatedAt(LocalDateTime.now());

		Note savedNote = noteRepository.save(note);

		return convertToResponse(savedNote);
	}

	@Override
	public NoteResponse archiveNote(Long id, String email) {

		User user = getUserByEmail(email);

		Note note = noteRepository.findByIdAndUser(id, user)
				.orElseThrow(() -> new NoteNotFoundException("Note not found with id " + id));

		note.setArchived(true);
		note.setUpdatedAt(LocalDateTime.now());

		Note savedNote = noteRepository.save(note);

		return convertToResponse(savedNote);
	}

	@Override
	public NoteResponse unarchiveNote(Long id, String email) {

		User user = getUserByEmail(email);

		Note note = noteRepository.findByIdAndUser(id, user)
				.orElseThrow(() -> new NoteNotFoundException("Note not found with id " + id));

		note.setArchived(false);
		note.setUpdatedAt(LocalDateTime.now());

		Note savedNote = noteRepository.save(note);

		return convertToResponse(savedNote);
	}

	@Override
	public NoteResponse moveToTrash(Long id, String email) {

		User user = getUserByEmail(email);

		Note note = noteRepository.findByIdAndUser(id, user)
				.orElseThrow(() -> new NoteNotFoundException("Note not found with id " + id));

		note.setTrashed(true);
		note.setUpdatedAt(LocalDateTime.now());

		Note savedNote = noteRepository.save(note);

		return convertToResponse(savedNote);
	}

	@Override
	public NoteResponse restoreFromTrash(Long id, String email) {

		User user = getUserByEmail(email);

		Note note = noteRepository.findByIdAndUser(id, user)
				.orElseThrow(() -> new NoteNotFoundException("Note not found with id " + id));

		note.setTrashed(false);
		note.setUpdatedAt(LocalDateTime.now());

		Note savedNote = noteRepository.save(note);

		return convertToResponse(savedNote);
	}

	@Override
	public List<NoteResponse> searchNotes(String email, String keyword) {

		User user = getUserByEmail(email);

		List<Note> notes = noteRepository.searchNotes(user, keyword);

		return notes.stream().map(this::convertToResponse).toList();
	}

	@Override
	public void addTagToNote(Long noteId, Long tagId, String email) {

		User user = getUserByEmail(email);

		Note note = noteRepository.findByIdAndUser(noteId, user)
				.orElseThrow(() -> new NoteNotFoundException("Note not found with id " + noteId));

		Tag tag = tagRepository.findById(tagId)
				.orElseThrow(() -> new TagNotFoundException("Tag not found with id " + tagId));

		if (!tag.getUser().getId().equals(user.getId())) {
			throw new TagNotFoundException("Tag not found with id " + tagId);
		}

		note.getTags().add(tag);

		noteRepository.save(note);
	}
}