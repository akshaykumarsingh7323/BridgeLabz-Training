package com.fundooapp.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "notes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String content;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	private boolean pinned = false;

	private boolean archived = false;

	private boolean trashed = false;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToMany
	@JoinTable(name = "note_tags", joinColumns = @JoinColumn(name = "note_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
	private Set<Tag> tags = new HashSet<>();
}