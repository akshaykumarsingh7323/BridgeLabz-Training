package com.interfaces.set;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CompareTwoSets {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set <Integer> set1 = new HashSet<>();
		System.out.println("Enter size of set 1: ");
		int n = sc.nextInt();
		
		System.out.println("Enter " + n + " element for set 1: ");
		for(int i = 0; i < n; i++) {
			set1.add(sc.nextInt());
		}
		
		Set <Integer> set2 = new HashSet<>();
		System.out.println("Enter size of set 2: ");
		n = sc.nextInt();
		
		System.out.println("Enter " + n + " element for set 2: ");
		for(int i = 0; i < n; i++) {
			set2.add(sc.nextInt());
		};
		
		if(set1.size() == set2.size() && set1.containsAll(set2)) {
			System.out.println("Set is equal");
		}else {
			System.out.println("Set is not equal");
		}
	}
}
