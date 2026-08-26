package com.fundooapp.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fundooapp.entity.Note;
import com.fundooapp.entity.User;

public interface NoteRepository extends JpaRepository<Note, Long> {

	List<Note> findByUser(User user);

	Optional<Note> findByIdAndUser(Long id, User user);

	@Query("""
			    SELECT n FROM Note n
			    WHERE n.user = :user
			    AND n.trashed = false
			    AND (
			        LOWER(n.title) LIKE LOWER(CONCAT('%', :keyword, '%'))
			        OR
			        LOWER(n.content) LIKE LOWER(CONCAT('%', :keyword, '%'))
			    )
			""")
	List<Note> searchNotes(@Param("user") User user, @Param("keyword") String keyword);

	@Query("""
			    SELECT n FROM Note n
			    WHERE n.user = :user
			    AND (:pinned IS NULL OR n.pinned = :pinned)
			    AND (:archived IS NULL OR n.archived = :archived)
			    AND (:trashed IS NULL OR n.trashed = :trashed)
			""")
	List<Note> findNotesWithFilters(@Param("user") User user, @Param("pinned") Boolean pinned,
			@Param("archived") Boolean archived, @Param("trashed") Boolean trashed);

	List<Note> findByReminderTimeLessThanEqualAndTrashedFalse(LocalDateTime reminderTime);
}