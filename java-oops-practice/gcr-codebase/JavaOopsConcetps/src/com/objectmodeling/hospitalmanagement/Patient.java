package com.objectmodeling.hospitalmanagement;

import java.util.*;

class Patient {
    private int patientId;
    private String name;
    private List<Doctor> doctors;

    public Patient(int patientId, String name) {
        this.patientId = patientId;
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void showDoctors() {
        System.out.println("Patient: " + name + " consulted:");
        for (Doctor d : doctors) {
            System.out.println(" - Dr. " + d.getName());
        }
    }
}
