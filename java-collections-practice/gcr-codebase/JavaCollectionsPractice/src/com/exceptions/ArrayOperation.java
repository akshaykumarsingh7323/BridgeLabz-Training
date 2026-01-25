package com.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;


public class ArrayOperation {

    static void printValueAtIndex(int[] arr, int index) {

        try {
            System.out.println("Value at index " + index + ": " + arr[index]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");

        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = null;
        int size = 0;

        System.out.print("Enter array size: ");
        try {
        	size = sc.nextInt();
    	}catch(InputMismatchException e) {
    		System.out.println("Please inter a valid input!");
    		return;
    	}

        if (size > 0) {
            arr = new int[size];
            System.out.println("Enter array elements:");
            for (int i = 0; i < size; i++) {
            	try {
            		arr[i] = sc.nextInt();
            	}catch(InputMismatchException e) {
            		System.out.println("Please inter a valid input!");
            		return;
            	}
            }
        }

        System.out.print("Enter index: ");
        try {
        	int index = sc.nextInt();
        	 printValueAtIndex(arr, index);

    	}catch(InputMismatchException e) {
    		System.out.println("Please inter a valid input!");
    	}
    }
}
