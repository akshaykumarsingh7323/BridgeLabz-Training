package com.patientmanagementsystem;

public class UseHospital {

    public static void main(String[] args) {

        Doctor d1 = new Doctor("D101", "Dr. Mehta", "Cardiology");
        d1.displayInfo();
        System.out.println("----------------");

        InPatient p1 = new InPatient("P201", "Rahul Verma", 45, "Heart Condition", 204, 3);
        OutPatient p2 = new OutPatient("P202", "Neha Singh", 30, "02-01-2026");

        p1.displayInfo();
        System.out.println("----------------");
        p2.displayInfo();

        Bill b1 = new Bill(p1, 12000);
        b1.applyDiscount(10);
        b1.printBill();

        Bill b2 = new Bill(p2, 2500);
        b2.printBill();
    }
}
