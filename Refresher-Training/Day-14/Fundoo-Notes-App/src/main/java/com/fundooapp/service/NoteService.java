package com.fundooapp.service;

import java.util.List;

import com.fundooapp.dto.NoteRequest;
import com.fundooapp.dto.NoteResponse;

public interface NoteService {

	NoteResponse createNote(String email, NoteRequest request);

	List<NoteResponse> getAllNotes(String email);

	NoteResponse getNoteById(Long id, String email);

	NoteResponse updateNote(Long id, String email, NoteRequest request);

	void deleteNote(Long id, String email);
}