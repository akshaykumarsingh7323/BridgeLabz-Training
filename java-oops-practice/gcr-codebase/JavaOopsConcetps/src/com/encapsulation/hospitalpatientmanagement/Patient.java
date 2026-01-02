package com.encapsulation.hospitalpatientmanagement;

import java.util.*;

abstract class Patient {
    private int patientId;
    private String name;
    private int age;

    private List<String> medicalHistory = new ArrayList<>();

    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    protected void addMedicalRecord(String record) {
        medicalHistory.add(record);
    }

    protected void showMedicalHistory() {
        for (String record : medicalHistory) {
            System.out.println("- " + record);
        }
    }

    public abstract double calculateBill();
}
