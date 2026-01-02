package com.encapsulation.vehiclerentalsystem;

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    protected double rentalRate;  

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public abstract double calculateRentalCost(int days);
}
