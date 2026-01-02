package com.encapsulation.vehiclerentalsystem;

class Bike extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Bike(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
        this.insurancePolicyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return rentalRate * days;
    }

    @Override
    public double calculateInsurance() {
        return 200.0;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance Policy: ****" +
               insurancePolicyNumber.substring(insurancePolicyNumber.length() - 4);
    }
}
