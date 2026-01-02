package com.vehiclerentalapplication;

public class Truck extends Vehicle {

    private double loadCapacity; // in tons

    public Truck(String id, String model, double rate, double loadCapacity) {
        super(id, model, rate);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public double calculateRent(int days) {
        double rent = baseRate * days;

        // Operator use: Heavy load surcharge +15% if load > 5 tons
        if (loadCapacity > 5) {
            rent += rent * 0.15;
        }
        return rent;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Truck | Load Capacity: " + loadCapacity + " tons");
    }
}
