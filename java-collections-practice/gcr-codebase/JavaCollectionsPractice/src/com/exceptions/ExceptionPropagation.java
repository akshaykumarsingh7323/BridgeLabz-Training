package com.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionPropagation {
	
	static void method1(int a, int b) {
		int c = a / b;
		
		System.out.println("Division is " + c);
	}
	
	static void method2(int a, int b) {
		method1(a, b);
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			System.out.println("Enter first number: ");
			int a = sc.nextInt();
			
			System.out.println("Enter second number: ");
			int b = sc.nextInt();
			
			method2(a, b);
			
		}catch(ArithmeticException e) {
			
			System.out.println("Can't divide by 0!");
			
		}catch(InputMismatchException e) {
			
			System.out.println("Please enter a valid input!");
			
		}
	}
}
