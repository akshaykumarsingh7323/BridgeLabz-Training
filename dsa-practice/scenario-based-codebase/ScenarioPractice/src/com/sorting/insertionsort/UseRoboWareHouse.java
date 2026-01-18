package com.sorting.insertionsort;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UseRoboWareHouse {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShelfManager manager = new ShelfManager();
        int n = 0;
        boolean valid = false;
        System.out.print("Enter number of packages: ");
        while(!valid) {
        	try {
		        n = sc.nextInt();
		        sc.nextLine(); 
		        valid = true;
        	} catch(InputMismatchException e) {
        		System.out.println("\nPlease enter a valid integer");
        		sc.next();
        	}
        }
        PackageItem[] packages = new PackageItem[n];

        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter package ID: ");
            String id = sc.nextLine();
            System.out.print("\nEnter package weight: ");
            double weight = sc.nextDouble();
            sc.nextLine();

            packages[i] = new PackageItem(id, weight);
        }

        manager.addPackages(packages);
        manager.displayPackages(packages);
    }
}
