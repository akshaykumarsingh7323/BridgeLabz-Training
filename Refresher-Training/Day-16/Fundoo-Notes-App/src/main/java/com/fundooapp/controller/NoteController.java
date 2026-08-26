package com.fundooapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fundooapp.dto.NoteRequest;
import com.fundooapp.dto.NoteResponse;
import com.fundooapp.service.NoteService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
public class NoteController {

	private final NoteService noteService;

	@PostMapping
	public ResponseEntity<NoteResponse> createNote(@Valid @RequestBody NoteRequest request,
			Authentication authentication) {

		String email = authentication.getName();

		NoteResponse response = noteService.createNote(email, request);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping
	public ResponseEntity<List<NoteResponse>> getAllNotes(@RequestParam(required = false) Boolean pinned,
			@RequestParam(required = false) Boolean archived, @RequestParam(required = false) Boolean trashed,
			Authentication authentication) {

		String email = authentication.getName();

		return ResponseEntity.ok(noteService.getAllNotes(email, pinned, archived, trashed));
	}

	@GetMapping("/{id}")
	public ResponseEntity<NoteResponse> getNoteById(@PathVariable Long id, Authentication authentication) {

		String email = authentication.getName();

		return ResponseEntity.ok(noteService.getNoteById(id, email));
	}

	@PutMapping("/{id}")
	public ResponseEntity<NoteResponse> updateNote(@PathVariable Long id, @Valid @RequestBody NoteRequest request,
			Authentication authentication) {

		String email = authentication.getName();

		return ResponseEntity.ok(noteService.updateNote(id, email, request));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteNote(@PathVariable Long id, Authentication authentication) {

		String email = authentication.getName();

		noteService.deleteNote(id, email);

		return ResponseEntity.ok("Note deleted successfully");
	}

	@PostMapping("/{id}/pin")
	public ResponseEntity<NoteResponse> pinNote(@PathVariable Long id, Authentication authentication) {

		String email = authentication.getName();

		return ResponseEntity.ok(noteService.pinNote(id, email));
	}

	@PostMapping("/{id}/unpin")
	public ResponseEntity<NoteResponse> unpinNote(@PathVariable Long id, Authentication authentication) {

		String email = authentication.getName();

		return ResponseEntity.ok(noteService.unpinNote(id, email));
	}

	@PostMapping("/{id}/archive")
	public ResponseEntity<NoteResponse> archiveNote(@PathVariable Long id, Authentication authentication) {

		String email = authentication.getName();

		return ResponseEntity.ok(noteService.archiveNote(id, email));
	}

	@PostMapping("/{id}/unarchive")
	public ResponseEntity<NoteResponse> unarchiveNote(@PathVariable Long id, Authentication authentication) {

		String email = authentication.getName();

		return ResponseEntity.ok(noteService.unarchiveNote(id, email));
	}

	@PostMapping("/{id}/trash")
	public ResponseEntity<NoteResponse> moveToTrash(@PathVariable Long id, Authentication authentication) {

		String email = authentication.getName();

		return ResponseEntity.ok(noteService.moveToTrash(id, email));
	}

	@PostMapping("/{id}/restore")
	public ResponseEntity<NoteResponse> restoreFromTrash(@PathVariable Long id, Authentication authentication) {

		String email = authentication.getName();

		return ResponseEntity.ok(noteService.restoreFromTrash(id, email));
	}

	@GetMapping("/search")
	public ResponseEntity<List<NoteResponse>> searchNotes(@RequestParam String keyword, Authentication authentication) {

		String email = authentication.getName();

		return ResponseEntity.ok(noteService.searchNotes(email, keyword));
	}

	@PostMapping("/{noteId}/tags/{tagId}")
	public ResponseEntity<String> addTagToNote(@PathVariable Long noteId, @PathVariable Long tagId,
			Authentication authentication) {

		String email = authentication.getName();

		noteService.addTagToNote(noteId, tagId, email);

		return ResponseEntity.ok("Tag added to note successfully");
	}
}