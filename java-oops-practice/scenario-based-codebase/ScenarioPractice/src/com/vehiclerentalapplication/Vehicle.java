package com.vehiclerentalapplication;

public abstract class Vehicle implements Rental {

    protected String vehicleId;
    protected String model;
    protected double baseRate;   // per day rate

    public Vehicle(String vehicleId, String model, double baseRate) {
        this.vehicleId = vehicleId;
        this.model = model;
        this.baseRate = baseRate;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getModel() {
        return model;
    }

    public double getBaseRate() {
        return baseRate;
    }

    public void displayInfo() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Model: " + model);
        System.out.println("Base Rate/Day: " + baseRate);
    }
}
