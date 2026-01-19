package com.sorting.cropmonitor;

import java.util.Scanner;

public class UseCropMonitor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of sensor readings: ");
        int n = sc.nextInt();

        SensorReading[] readings = new SensorReading[n];

        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter timestamp for reading " + (i + 1) + ": ");
            long time = sc.nextLong();

            System.out.print("Enter temperature: ");
            double temp = sc.nextDouble();

            readings[i] = new SensorReading(time, temp);
        }

        QuickSort.quickSort(readings, 0, n - 1);

        System.out.println("\nSorted Sensor Data by Timestamp:");
        for (SensorReading r : readings) {
            System.out.println("Timestamp: " + r.timestamp + " | Temp: " + r.temperature);
        }
    }
}
