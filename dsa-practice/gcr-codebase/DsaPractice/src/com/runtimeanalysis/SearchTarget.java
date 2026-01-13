package com.runtimeanalysis;

import java.util.Arrays;
import java.util.Scanner;

public class SearchTarget {
	static boolean linearSearch(int arr[], int target) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == target) {
				return true;
			}
		}
		return false;
	}
	
	static boolean binarySearch(int arr[], int target) {
		int start = 0;
		int end = arr.length-1;
		while(start <= end) {
			int mid = (start + end)/2;
			if(arr[mid] == target) {
				return true;
			}else if(target > arr[mid]) {
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array: ");
		int size = sc.nextInt();
		int arr[] = new int[size];
		
		for(int i = 0; i < size; i++) {
			arr[i] = i;
		}
		
		System.out.println(Arrays.toString(arr));
		
		System.out.println("Enter target: ");
		int target =  sc.nextInt();
		
		long startLinear = System.nanoTime();
		boolean linearResult = linearSearch(arr, target);
		long endLinear = System.nanoTime();
		long linearTime = endLinear - startLinear;
		
		if(linearResult) System.out.println("Target found in linear search");
		else System.out.println("Target not found in linear search");
		
 		System.out.println("Linear Time: " + linearTime);
		
		long startBinary = System.nanoTime();
		boolean binaryResult = binarySearch(arr, target);
		long endBinary = System.nanoTime();
		long binaryTime = endBinary - startBinary;
		
		if(binaryResult) System.out.println("Target found in binary search");
		else System.out.println("Target not 19ound in binary search");
		
		System.out.println("Binary Time: " + binaryTime);
	}
}
