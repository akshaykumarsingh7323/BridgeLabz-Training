package com.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UncheckedException {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter first number: ");
			int a = sc.nextInt();
			
			System.out.println("Enter second number: ");
			int b = sc.nextInt();
			
			int c = a / b;
			System.out.println("Division is " + c);
			
		}catch(ArithmeticException e) {
			
			System.out.println("Can't divide by 0!");
			
		}catch(InputMismatchException e) {
			
			System.out.println("Please enter a valid input!");
			
		}
	}
}
