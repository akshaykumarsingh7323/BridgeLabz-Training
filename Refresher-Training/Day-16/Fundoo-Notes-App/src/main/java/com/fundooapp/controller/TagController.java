package com.fundooapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundooapp.dto.TagRequest;
import com.fundooapp.dto.TagResponse;
import com.fundooapp.service.TagService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tags")
@RequiredArgsConstructor
public class TagController {

	private final TagService tagService;

	@PostMapping
	public ResponseEntity<TagResponse> createTag(@Valid @RequestBody TagRequest request,
			Authentication authentication) {

		String email = authentication.getName();

		return ResponseEntity.status(HttpStatus.CREATED).body(tagService.createTag(email, request));
	}

	@GetMapping
	public ResponseEntity<List<TagResponse>> getAllTags(Authentication authentication) {

		String email = authentication.getName();

		return ResponseEntity.ok(tagService.getAllTags(email));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTag(@PathVariable Long id, Authentication authentication) {

		String email = authentication.getName();

		tagService.deleteTag(id, email);

		return ResponseEntity.ok("Tag deleted successfully");
	}
}