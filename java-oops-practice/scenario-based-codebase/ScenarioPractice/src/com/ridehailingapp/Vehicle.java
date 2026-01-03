package com.ridehailingapp;

abstract class Vehicle {

    private String vehicleNumber;
    private int capacity;
    private String type;

    public Vehicle(String vehicleNumber, int capacity, String type) {
        this.vehicleNumber = vehicleNumber;
        this.capacity = capacity;
        this.type = type;
    }

    public abstract double calculateFare(double distance);

    public String getVehicleDetails() {
        return "Vehicle Number: " + vehicleNumber +
               ", Type: " + type +
               ", Capacity: " + capacity;
    }
}

