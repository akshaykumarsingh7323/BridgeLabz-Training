package com.ridehailingapp;

class SUV extends Vehicle {

    private final double ratePerKm = 20;
    private final double baseFare = 100;

    public SUV(String vehicleNumber) {
        super(vehicleNumber, 6, "SUV");
    }

    @Override
    public double calculateFare(double distance) {
        return baseFare + (distance * ratePerKm);
    }
}
