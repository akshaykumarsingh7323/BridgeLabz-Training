package com.interfaces.set;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FindSubset {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set <Integer> set1 = new HashSet<>();
		System.out.println("Enter size of set 1: ");
		int n = sc.nextInt();
		
		System.out.println("Enter " + n + " element for set1: ");
		for(int i = 0; i < n; i++) {
			set1.add(sc.nextInt());
		}
		
		Set <Integer> set2 = new HashSet<>();
		System.out.println("Enter size of set 2: ");
		n = sc.nextInt();
		
		System.out.println("Enter " + n + " element for set2: ");
		for(int i = 0; i < n; i++) {
			set2.add(sc.nextInt());
		}
		
		if(set1.containsAll(set2)) System.out.println("Set 2 is subset of set 1");
		else if(set2.containsAll(set1)) System.out.println("Set 1 is subset of set 2");
		else System.out.println("No Subset Found");
	
	}
}
