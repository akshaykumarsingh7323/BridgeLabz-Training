package com.constructor.level1;

public class UseVehicle {
	public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Akshay", "Car");
        Vehicle v2 = new Vehicle("Ravi", "Bike");

        v1.displayVehicleDetails();
        v2.displayVehicleDetails();

        Vehicle.updateRegistrationFee(6000.0);

        System.out.println("\nAfter updating registration fee:\n");

        v1.displayVehicleDetails();
        v2.displayVehicleDetails();
    }
}
