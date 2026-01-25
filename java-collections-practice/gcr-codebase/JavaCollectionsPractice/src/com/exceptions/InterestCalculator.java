package com.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterestCalculator {

    static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {

        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException(
                    "Invalid input: Amount and rate must be positive");
        }

        return (amount * rate * years) / 100;
    }

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        try {
        	System.out.println("Enter amount: ");
        	double amount = sc.nextDouble();

        	System.out.println("Enter rate percent: ");
        	double rate = sc.nextDouble();
        	
        	System.out.println("Enter time: ");
        	int time = sc.nextInt();
        	
            double interest = calculateInterest(amount, rate, time);
            System.out.println("Calculated Interest: " + interest);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }catch(InputMismatchException e) {
        	System.out.println("Invalid input!");
        }
    }
}

