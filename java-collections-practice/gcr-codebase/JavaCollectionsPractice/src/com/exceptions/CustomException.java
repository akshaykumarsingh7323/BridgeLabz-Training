package com.exceptions;

import java.util.*;

class InvalidAgeException extends Exception{
	InvalidAgeException(String message){
		super(message);
	}
}

public class CustomException{
	static void validateAge(int age) throws InvalidAgeException {
		if(age < 18) {
			throw new InvalidAgeException("Age must be 18 or above");
		}
		System.out.println("Access granted");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		try {
			System.out.println("Enter age: ");
			int age = sc.nextInt();
			
			validateAge(age);
			
		}catch(InvalidAgeException e) {
			System.out.println(e.getMessage());
		}catch(InputMismatchException e){
			System.out.println("Please enter a valid input!");
		}
	}
}
