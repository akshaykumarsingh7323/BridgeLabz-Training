package com.linearandbinarysearch;

import java.util.Scanner;

public class FindRotationPoint {
	static int findRotationPoint(int arr []) {
		int start = 0;
		int end = arr.length - 1;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			if(arr[mid] > arr[start] && arr[start] > arr[end]) start = mid + 1;
			else if(arr[mid] == arr[start] && arr[start] > arr[end]) 	start = mid + 1;
			else if(arr[start] > arr[mid] && arr[mid] < arr[end]) end = mid;
			else end = mid - 1;
		}
		return start;
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
