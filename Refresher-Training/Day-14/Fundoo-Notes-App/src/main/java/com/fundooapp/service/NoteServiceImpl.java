package com.fundooapp.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fundooapp.dto.NoteRequest;
import com.fundooapp.dto.NoteResponse;
import com.fundooapp.entity.Note;
import com.fundooapp.entity.User;
import com.fundooapp.exception.NoteNotFoundException;
import com.fundooapp.exception.UserNotFoundException;
import com.fundooapp.repository.NoteRepository;
import com.fundooapp.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    private final UserRepository userRepository;


    @Override
    public NoteResponse createNote(
            String email,
            NoteRequest request) {

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
    public List<NoteResponse> getAllNotes(
            String email) {

        User user = getUserByEmail(email);

        return noteRepository.findByUser(user)
                .stream()
                .map(this::convertToResponse)
                .toList();
    }


    @Override
    public NoteResponse getNoteById(
            Long id,
            String email) {

        User user = getUserByEmail(email);

        Note note = noteRepository
                .findByIdAndUser(id, user)
                .orElseThrow(() ->
                        new NoteNotFoundException(
                                "Note not found with id: " + id
                        )
                );

        return convertToResponse(note);
    }


    @Override
    public NoteResponse updateNote(
            Long id,
            String email,
            NoteRequest request) {

        User user = getUserByEmail(email);

        Note note = noteRepository
                .findByIdAndUser(id, user)
                .orElseThrow(() ->
                        new NoteNotFoundException(
                                "Note not found with id: " + id
                        )
                );

        note.setTitle(request.getTitle());

        note.setContent(request.getContent());

        note.setUpdatedAt(LocalDateTime.now());

        Note updatedNote = noteRepository.save(note);

        return convertToResponse(updatedNote);
    }


    @Override
    public void deleteNote(
            Long id,
            String email) {

        User user = getUserByEmail(email);

        Note note = noteRepository
                .findByIdAndUser(id, user)
                .orElseThrow(() ->
                        new NoteNotFoundException(
                                "Note not found with id: " + id
                        )
                );

        noteRepository.delete(note);
    }


    private User getUserByEmail(String email) {

        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "User not found with email: " + email
                        )
                );
    }


    private NoteResponse convertToResponse(Note note) {

        return new NoteResponse(
                note.getId(),
                note.getTitle(),
                note.getContent(),
                note.getCreatedAt(),
                note.getUpdatedAt()
        );
    }
}