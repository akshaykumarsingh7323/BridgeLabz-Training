package com.interfaces.set;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SymmetricDifference {
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

        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);

        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        union.removeAll(intersection);

        System.out.println("Symmetric Difference: " + union);
    }
}
