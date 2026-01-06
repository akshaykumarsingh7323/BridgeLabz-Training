package com.sortingalgorithm.bubblesort;

import java.util.Arrays;
import java.util.Scanner;

// Create a class for bubble sort
public class BubbleSort {
	static void bubbleSort(int []arr) {
		int n = arr.length;
		for(int i = 0; i < n - 1; i++) {
			for(int j = 0; j < n - 1 - i; j++) {
				if(arr[j] > arr[j + 1]){
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		System.out.println("After sorting : " + Arrays.toString(arr));
	}
	public static void main(String args []) {
		Scanner sc = new Scanner(System.in);
		
		//Takig input from the user
		System.out.println("Enter size of array: ");
		int n = sc.nextInt();
		
		int arr [] = new int [n];	
		System.out.println("Enter " + n + " elements : ");
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("Before sorting : " + Arrays.toString(arr));
		
		bubbleSort(arr);
	}
}
