package com.fundooapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableJms
@SpringBootApplication
public class FundooNotesAppApplication {

	public static void main(String[] args) {
		System.out.println("Application started successfully");

		SpringApplication.run(FundooNotesAppApplication.class, args);

	}
}