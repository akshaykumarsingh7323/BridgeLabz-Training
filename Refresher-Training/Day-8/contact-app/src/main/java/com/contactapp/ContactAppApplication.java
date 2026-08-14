package com.contactapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactAppApplication {

    public static void main(String[] args) {
    	System.out.println("Application started");

        SpringApplication.run(ContactAppApplication.class, args);
    }
}