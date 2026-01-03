package com.ridehailingapp;

class Mini extends Vehicle {

    private final double ratePerKm = 10;
    private final double baseFare = 50;

    public Mini(String vehicleNumber) {
        super(vehicleNumber, 4, "Mini");
    }

    @Override
    public double calculateFare(double distance) {
        return baseFare + (distance * ratePerKm);
    }
}
