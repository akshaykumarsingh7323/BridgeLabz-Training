package com.fundooapp.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.fundooapp.entity.Note;
import com.fundooapp.messaging.NotificationProducer;
import com.fundooapp.repository.NoteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReminderScheduler {

	private final NoteRepository noteRepository;

	private final NotificationProducer notificationProducer;

	@Scheduled(fixedRate = 60000)
	public void checkReminders() {

		LocalDateTime now = LocalDateTime.now();

		List<Note> notes = noteRepository.findByReminderTimeLessThanEqualAndTrashedFalse(now);

		for (Note note : notes) {

			notificationProducer.sendNotification("Reminder: " + note.getTitle());

			// clear the Reminder 
			note.setReminderTime(null);

			noteRepository.save(note);
		}
	}
}