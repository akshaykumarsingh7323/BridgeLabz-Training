package com.ridehailingapp;

class Sedan extends Vehicle {

    private final double ratePerKm = 15;
    private final double baseFare = 70;

    public Sedan(String vehicleNumber) {
        super(vehicleNumber, 4, "Sedan");
    }

    @Override
    public double calculateFare(double distance) {
        return baseFare + (distance * ratePerKm);
    }
}
