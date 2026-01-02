package com.encapsulation.hospitalpatientmanagement;

import java.util.*;

public class UseHospital {
    public static void main(String[] args) {

        List<Patient> patients = new ArrayList<>();

        InPatient ip = new InPatient(101, "Ramesh", 45, 5, 3000);
        OutPatient op = new OutPatient(102, "Sita", 30, 800);

        ip.addRecord("Diagnosed with pneumonia");
        ip.addRecord("Underwent X-ray");

        op.addRecord("Routine check-up");
        op.addRecord("Prescribed vitamins");

        patients.add(ip);
        patients.add(op);

        for (Patient p : patients) {
            p.getPatientDetails();
            System.out.println("Total Bill: ₹" + p.calculateBill());

            if (p instanceof MedicalRecord) {
                ((MedicalRecord) p).viewRecords();
            }

            System.out.println("--------------------------------");
        }
    }
}
