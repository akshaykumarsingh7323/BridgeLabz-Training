package com.sorting.insertionsort;

public class ShelfManager {

    public void addPackages(PackageItem[] packages) {
        InsertionSort.sort(packages);
    }

    public void displayPackages(PackageItem[] packages) {
        System.out.println("\nPackages on Shelf (Ascending by weight):");
        for (PackageItem p : packages) {
            System.out.println(p);
        }
    }
}
