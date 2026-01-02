package com.hospitalmanagementsystem;

public class Appointment {

    private String appointmentId;
    private Doctor doctor;
    private Patient patient;

    public Appointment(String appointmentId, Doctor doctor, Patient patient) {
        this.appointmentId = appointmentId;
        this.doctor = doctor;
        this.patient = patient;
    }

    public void showAppointmentDetails() {
        System.out.println("\n--- Appointment Details ---");
        System.out.println("Appointment ID: " + appointmentId);

        doctor.showDetails();
        patient.showDetails();
    }
}