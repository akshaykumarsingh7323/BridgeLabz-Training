package com.interfaces.queue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Patient implements Comparable<Patient>{
	private String name;
	private int severity;
	
	public Patient(String name, int severity) {
		this.name = name;
		this.severity = severity;
	}
	
	int getSeverity() {
		return severity;
	}
	
	@Override
	public String toString() {
		return "Name: " + name + ", severity: " + severity;
	}
	
	@Override
	public int compareTo(Patient obj) {
		return Integer.compare(this.severity, obj.severity);
	}
}

public class HospitalTriageSystem {
	public static void main(String[] args) {
		PriorityQueue<Patient> patient = new PriorityQueue<>(Collections.reverseOrder());
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of patients");
		int n = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i < n; i++) {
			System.out.println("\nEnter name of patient:");
			String name = sc.nextLine();
			
			System.out.println("Enter severity of patient:");
			int severity = sc.nextInt();
			sc.nextLine();
			
			patient.add(new Patient(name, severity));
			System.out.println("Patient added");
		}
		
		System.out.println("\nAll Patient details in sorted order by their severity are: ");
		while(!patient.isEmpty()) {
			System.out.println(patient.poll());
		}
	}
}
