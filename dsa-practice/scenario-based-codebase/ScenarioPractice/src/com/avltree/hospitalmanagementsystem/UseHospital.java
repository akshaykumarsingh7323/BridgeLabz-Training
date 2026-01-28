package com.avltree.hospitalmanagementsystem;

public class UseHospital {

    public static void main(String[] args) {

        HospitalAVL hospital = new HospitalAVL();

        hospital.registerPatient(930, "Ramesh");
        hospital.registerPatient(845, "Anita");
        hospital.registerPatient(1015, "Suresh");
        hospital.registerPatient(900, "Meena");
        hospital.registerPatient(1100, "Vikram");

        System.out.println("Patient Queue (By Arrival Time):");
        hospital.displayQueue();

        System.out.println("\nDischarging patient at 09:00");
        hospital.dischargePatient(900);

        System.out.println("\nUpdated Queue:");
        hospital.displayQueue();
    }
}

