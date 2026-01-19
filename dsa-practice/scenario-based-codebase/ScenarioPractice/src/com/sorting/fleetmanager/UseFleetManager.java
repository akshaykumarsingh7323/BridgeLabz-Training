package com.sorting.fleetmanager;

import java.util.Scanner;

public class UseFleetManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vehicles: ");
        int n = sc.nextInt();

        Vehicle[] vehicles = new Vehicle[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter mileage for vehicle " + (i + 1) + ": ");
            int mileage = sc.nextInt();
            vehicles[i] = new Vehicle(mileage);
        }

        MergeSort.mergeSort(vehicles, 0, n - 1);

        System.out.println("\nMaster Maintenance Schedule (Sorted by Mileage):");
        for (Vehicle v : vehicles) {
            System.out.println("Mileage: " + v.mileage);
        }
    }
}
