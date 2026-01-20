package com.sorting.icecreamrush;

import java.util.Scanner;

public class UseIceCreamRush {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 8; 
        Flavor[] flavors = new Flavor[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter flavor name " + (i + 1) + ": ");
            String name = sc.next();

            System.out.print("Enter weekly sales for " + name + ": ");
            int sales = sc.nextInt();

            flavors[i] = new Flavor(name, sales);
        }

        BubbleSort.sortByPopularity(flavors);

        System.out.println("\nFlavors Sorted by Popularity:");
        for (Flavor f : flavors) {
            System.out.println(f.name + " → Sales: " + f.sales);
        }
    }
}

