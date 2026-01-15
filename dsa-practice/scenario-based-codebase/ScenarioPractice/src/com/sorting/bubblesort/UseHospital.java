package com.sorting.bubblesort;

import java.util.Scanner;

public class UseHospital {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of patients: ");
        int n = sc.nextInt();
        sc.nextLine();
        Patient patients [] = new Patient[n];
        
        for(int i = 0 ; i < n; i++) {
        	System.out.println("\nEnter patient name and criticality for patient " + (i + 1)+ " :");
	        String name = sc.next();
	        int criticality = sc.nextInt();
	        patients[i] = new Patient(name, criticality);
        }

        HospitalQueue queue = new HospitalQueue();

        System.out.println("Before Sorting:");
        queue.displayPatients(patients);

        queue.sortByCriticality(patients);

        System.out.println("\nAfter Sorting by Criticality:");
        queue.displayPatients(patients);
    }
}

