package com.patientmanagementsystem;

public class Bill implements Payable {

    private Patient patient;
    private double baseAmount;
    private double taxRate = 0.18;
    private double discount = 0.0;

    public Bill(Patient patient, double baseAmount) {
        this.patient = patient;
        this.baseAmount = baseAmount;

        // Emergency → additional 5% charge (operator usage)
        if (patient.emergencyCase) {
            this.baseAmount += baseAmount * 0.05;
        }
    }

    public void applyDiscount(double percent) {
        discount = baseAmount * (percent / 100);
    }

    @Override
    public double calculatePayment() {
        double taxableAmount = baseAmount - discount;
        double tax = taxableAmount * taxRate;
        return taxableAmount + tax;
    }

    public void printBill() {
        System.out.println("\n--- Billing Summary ---");
        System.out.println(patient.getSummary());
        System.out.println("Base Amount: " + baseAmount);
        System.out.println("Discount: " + discount);
        System.out.println("Total Payable: " + calculatePayment());
    }
}
