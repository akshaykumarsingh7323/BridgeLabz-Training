package com.foreach.emailnotification;

import java.util.*;

public class SentEmailNotification {
	
	static void sentNotification(String email) {
		System.out.println("new notification for you " + email);
	}
	
	public static void main(String[] args) {
		List<String> emails = Arrays.asList("akshay@gmail.com", "aman@gmail.com", "shyam@gmail.com", "deepanshu@gmail.com", "priyanshu@gmail.com");	
		emails.forEach(email -> sentNotification(email));
	}
}
