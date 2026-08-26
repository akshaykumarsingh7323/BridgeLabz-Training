package com.fundooapp.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class JmsConfig {

    public static final String NOTIFICATION_QUEUE =
            "fundoo.notification.queue";
}