package com.patientmanagementsystem;

public class InPatient extends Patient {

    private int roomNumber;
    private int daysAdmitted;

    public InPatient(String id, String name, int age, int roomNumber, int daysAdmitted) {
        super(id, name, age);
        this.roomNumber = roomNumber;
        this.daysAdmitted = daysAdmitted;
    }

    public InPatient(String id, String name, int age, String history, int roomNumber, int daysAdmitted) {
        super(id, name, age, history, true); // emergency admission
        this.roomNumber = roomNumber;
        this.daysAdmitted = daysAdmitted;
    }

    public int getDaysAdmitted() {
        return daysAdmitted;
    }

    @Override
    public void displayInfo() {
        System.out.println(getSummary());
        System.out.println("Type: In-Patient");
        System.out.println("Room No: " + roomNumber);
        System.out.println("Days Admitted: " + daysAdmitted);
    }
}
