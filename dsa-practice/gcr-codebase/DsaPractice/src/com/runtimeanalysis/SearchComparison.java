package com.runtimeanalysis;

import java.util.*;

public class SearchComparison {

    public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    		
    		System.out.println("Enter size: ");
    		int n = sc.nextInt();      
    		
    		System.out.println("Enter target: ");
        int searchElement = sc.nextInt(); 
        
        // ---------- Array ----------
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        long startArray = System.nanoTime();
        boolean foundInArray = false;
        for (int i = 0; i < n; i++) {
            if (arr[i] == searchElement) {
                foundInArray = true;
                break;
            }
        }
        long endArray = System.nanoTime();

        // ---------- HashSet ----------
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hashSet.add(i);
        }

        long startHashSet = System.nanoTime();
        boolean foundInHashSet = hashSet.contains(searchElement);
        long endHashSet = System.nanoTime();

        // ---------- TreeSet ----------
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            treeSet.add(i);
        }

        long startTreeSet = System.nanoTime();
        boolean foundInTreeSet = treeSet.contains(searchElement);
        long endTreeSet = System.nanoTime();

        // ---------- Output ----------
        System.out.println("Search Element: " + searchElement);
        
        System.out.println("Array Found: " + foundInArray + " and Time: " + (endArray - startArray) + " ns");

        System.out.println("HashSet Found: " + foundInHashSet + " and Time: " + (endHashSet - startHashSet) + " ns");

        System.out.println("TreeSet Found: " + foundInTreeSet + " and Time: " + (endTreeSet - startTreeSet) + " ns");
    }
}
