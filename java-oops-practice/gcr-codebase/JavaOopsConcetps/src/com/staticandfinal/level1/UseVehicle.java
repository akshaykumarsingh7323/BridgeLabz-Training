package com.staticandfinal.level1;

public class UseVehicle {

	public static void main(String[] args) {
		
		System.out.println("\n----- Vehicle Registration System ------\n");
		
		Vehicle.updateRegistrationFee(150.0); 
		
        Vehicle vehicle1 = new Vehicle("Honest raj", "Sedan", "ABC123");
        Vehicle vehicle2 = new Vehicle("Price danish", "SUV", "XYZ789");
        
        vehicle1.displayRegistrationDetails();
        
        System.out.println();
        
        vehicle2.displayRegistrationDetails();
	   }
}
