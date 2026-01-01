package com.objectmodeling.hospitalmanagement;

public class UseHospital {
    public static void main(String[] args) {

        Hospital hospital = new Hospital("City Care Hospital");

        Doctor d1 = new Doctor(1, "Sharma");
        Doctor d2 = new Doctor(2, "Mehta");

        Patient p1 = new Patient(101, "Akshay");
        Patient p2 = new Patient(102, "Rohan");

        hospital.addDoctor(d1);
        hospital.addDoctor(d2);

        hospital.addPatient(p1);
        hospital.addPatient(p2);

        d1.consult(p1);
        d1.consult(p2);
        d2.consult(p1);

        d1.showPatients();
        d2.showPatients();

        p1.showDoctors();
        p2.showDoctors();
    }
}
