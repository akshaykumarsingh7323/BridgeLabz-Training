package com.encapsulation.vehiclerentalsystem;

class Car extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Car(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.insurancePolicyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    @Override
    public double calculateInsurance() {
        return 500.0; 
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Policy: ****" +
               insurancePolicyNumber.substring(insurancePolicyNumber.length() - 4);
    }
}
