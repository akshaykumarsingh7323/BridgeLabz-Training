package com.fundooapp.messaging;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.fundooapp.config.JmsConfig;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationProducer {

	private final JmsTemplate jmsTemplate;

	public void sendNotification(String message) {

		jmsTemplate.convertAndSend(JmsConfig.NOTIFICATION_QUEUE, message);
	}
}