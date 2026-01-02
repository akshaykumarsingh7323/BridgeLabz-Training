package com.encapsulation.hospitalpatientmanagement;

class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyCharge;

    public InPatient(int id, String name, int age, int days, double charge) {
        super(id, name, age);
        this.daysAdmitted = days;
        this.dailyCharge = charge;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    @Override
    public void addRecord(String record) {
        addMedicalRecord(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("In-Patient Medical History:");
        showMedicalHistory();
    }
}
