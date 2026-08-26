package com.fundooapp.messaging;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.fundooapp.config.JmsConfig;

@Service
public class NotificationConsumer {

	@JmsListener(destination = JmsConfig.NOTIFICATION_QUEUE)
	public void receiveNotification(String message) {

		System.out.println("Received JMS message: " + message);
	}
}