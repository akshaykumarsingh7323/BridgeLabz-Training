package com.vehiclerentalapplication;

public class Car extends Vehicle {

    private boolean luxuryVariant;

    public Car(String id, String model, double rate, boolean luxuryVariant) {
        super(id, model, rate);
        this.luxuryVariant = luxuryVariant;
    }

    @Override
    public double calculateRent(int days) {
        double rent = baseRate * days;

        // Operator use: Luxury surcharge +12%
        if (luxuryVariant) {
            rent += rent * 0.12;
        }
        return rent;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Car | Luxury Variant: " + (luxuryVariant ? "Yes" : "No"));
    }
}
