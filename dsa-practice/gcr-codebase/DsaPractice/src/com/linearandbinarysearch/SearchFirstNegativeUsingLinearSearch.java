package com.linearandbinarysearch;

import java.util.Scanner;

public class SearchFirstNegativeUsingLinearSearch {
	
	static int checkNumber(int arr []) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] < 0) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String args []) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter size of Array: ");
		int n = sc.nextInt();
		
		int arr [] = new int [n];
		System.out.println("Enter " + n + "  numbers: ");
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		int result = checkNumber(arr);
		
		if(result < 0) {
			System.out.println("-1");
		}else {
			System.out.println("Number on index " + result + " is Negative");
		}
	}
}
