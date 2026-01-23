package com.interfaces.set;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SortedList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set <Integer> set = new HashSet<>();
		System.out.println("Enter size of set: ");
		int n = sc.nextInt();
		
		System.out.println("Enter " + n + " element for set: ");
		for(int i = 0; i < n; i++) {
			set.add(sc.nextInt());
		}
		System.out.println("Original Set: " + set);
		Set <Integer> sorted = new TreeSet<>();
		sorted.addAll(set);
		
		
		System.out.println("Sorted Sort " + sorted);
	}
}
