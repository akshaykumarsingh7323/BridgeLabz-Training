package com.patientmanagementsystem;

public class OutPatient extends Patient {

    private String visitDate;

    public OutPatient(String id, String name, int age, String visitDate) {
        super(id, name, age);
        this.visitDate = visitDate;
    }

    @Override
    public void displayInfo() {
        System.out.println(getSummary());
        System.out.println("Type: Out-Patient");
        System.out.println("Visit Date: " + visitDate);
    }
}
