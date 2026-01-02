package com.patientmanagementsystem;

public abstract class Patient {

    private String patientId;
    private String name;
    private int age;
    private String medicalHistory;   // sensitive → private
    protected boolean emergencyCase;

    // Normal admission
    public Patient(String patientId, String name, int age) {
        this(patientId, name, age, "", false);
    }

    // Overloaded constructor → Emergency admission
    public Patient(String patientId, String name, int age, String medicalHistory, boolean emergencyCase) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.medicalHistory = medicalHistory;
        this.emergencyCase = emergencyCase;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getSummary() {
        return "Patient: " + name + " | Age: " + age + " | Emergency: " + (emergencyCase ? "Yes" : "No");
    }

    public abstract void displayInfo();
}
