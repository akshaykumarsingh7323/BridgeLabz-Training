package com.constructor.level1;

public class Vehicle {

    String ownerName;
    String vehicleType;

    static double registrationFee = 5000.0;

    Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    void displayVehicleDetails() {
        System.out.println(
            "Owner Name: " + ownerName + ", Vehicle Type: " + vehicleType + ", Registration Fee: Rs " + registrationFee);
    }

    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
}    
