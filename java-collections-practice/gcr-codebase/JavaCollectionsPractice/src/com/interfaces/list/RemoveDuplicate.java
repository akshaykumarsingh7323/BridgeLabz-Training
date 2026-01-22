package com.interfaces.list;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class RemoveDuplicate {
	static Set<Integer> removeDuplicate(int arr []){
		Set <Integer> result = new LinkedHashSet<>(); 
		for(int n : arr) {
			result.add(n);
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size of array: ");
		int n = sc.nextInt();
		
		int arr [] = new int[n];
		
		System.out.println("Enter elements: ");
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
			
		System.out.println(removeDuplicate(arr));
	}
}
