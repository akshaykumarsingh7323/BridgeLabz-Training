package com.hospitalmanagementmanagementsystem;

public class UseHospital {
    public static void main(String[] args) {

        Doctor d1 = new Doctor("D101", "Dr. Mehta", 45, "Cardiologist");
        Patient p1 = new Patient("P501", "Rohan", 32, "Heart Issue");

        Appointment a1 = new Appointment("A9001", d1, p1);
        a1.showAppointmentDetails();

        System.out.println("\n-------------------------");

        Doctor d2 = new Doctor("D102", "Dr. Sharma", 38, "Orthopedic");
        Patient p2 = new Patient("P502", "Neha", 27, "Fracture");

        Appointment a2 = new Appointment("A9002", d2, p2);
        a2.showAppointmentDetails();
    }
}