package com.vehiclerentalapplication;

public class Bike extends Vehicle {

    private boolean helmetIncluded;

    public Bike(String id, String model, double rate, boolean helmetIncluded) {
        super(id, model, rate);
        this.helmetIncluded = helmetIncluded;
    }

    @Override
    public double calculateRent(int days) {
        double rent = baseRate * days;

        // Operator use: 5% discount if rental exceeds 5 days
        if (days > 5) {
            rent -= rent * 0.05;
        }
        return rent;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Bike | Helmet Included: " + (helmetIncluded ? "Yes" : "No"));
    }
}
