package com.linearandbinarysearch;

import java.util.Scanner;

public class FindRotationPointBinarySearch {
	 public static int findRotationPoint(int[] arr) {
	        int left = 0;
	        int right = arr.length - 1;

	        while (left < right) {
	            int mid = left + (right - left) / 2;

	            if (arr[mid] > arr[right]) {
	                left = mid + 1;
	            } else {
	                right = mid;
	            }
	        }
	        return left;
	    }
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array: ");
		int n = sc.nextInt();
		int arr [] = new int[n];
		
		System.out.println("Enter " + n + " Elements: ");
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("smallest number is on index "+ findRotationPoint(arr) + " and the number is " + arr[findRotationPoint(arr)]);
	}
}
