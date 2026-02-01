package com.foreach.eventattendeewelcomemessage;

import java.util.Arrays;
import java.util.*;

public class WelcomeMessage {
	public static void main(String[] args) {
		List<String> attendees = Arrays.asList("Akshay" , "Amit", "Aman", "Avinash", "Deepanshu", "Avinash", "Priyanshu");
		attendees.forEach(name -> System.out.println("Welcome to you " + name));
	}
}
