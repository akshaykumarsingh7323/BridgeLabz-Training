package com.sorting.bubblesort;

public class Patient {
	private String name;
	private int criticality; 
	
	public Patient(String name, int criticality) {
		this.name = name;
		this.criticality = criticality;
	}
	
	public int getCriticality() {
		return criticality;
	}
	
	public String getName() {
		return name;
	}
}
