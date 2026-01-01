package com.objectmodeling.hospitalmanagement;

import java.util.*;

class Doctor {
    private int doctorId;
    private String name;
    private List<Patient> patients;

    public Doctor(int doctorId, String name) {
        this.doctorId = doctorId;
        this.name = name;
        this.patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void consult(Patient patient) {
        patients.add(patient);
        patient.addDoctor(this);

        System.out.println(
            "Dr. " + name + " is consulting patient " + patient.getName()
        );
    }

    public void showPatients() {
        System.out.println("Dr. " + name + " consulted:");
        for (Patient p : patients) {
            System.out.println(" - " + p.getName());
        }
    }
}

