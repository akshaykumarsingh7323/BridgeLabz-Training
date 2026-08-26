package com.fundooapp.service;

import java.util.List;

import com.fundooapp.dto.NoteRequest;
import com.fundooapp.dto.NoteResponse;

public interface NoteService {

	NoteResponse createNote(String email, NoteRequest request);

	// Get all notes and filter optional
	List<NoteResponse> getAllNotes(String email, Boolean pinned, Boolean archived, Boolean trashed);

	NoteResponse getNoteById(Long id, String email);

	NoteResponse updateNote(Long id, String email, NoteRequest request);

	void deleteNote(Long id, String email);

	// Pin
	NoteResponse pinNote(Long id, String email);

	NoteResponse unpinNote(Long id, String email);

	// Archive
	NoteResponse archiveNote(Long id, String email);

	NoteResponse unarchiveNote(Long id, String email);

	// Trash
	NoteResponse moveToTrash(Long id, String email);

	NoteResponse restoreFromTrash(Long id, String email);

	// Search
	List<NoteResponse> searchNotes(String email, String keyword);

	void addTagToNote(Long noteId, Long tagId, String email);
}