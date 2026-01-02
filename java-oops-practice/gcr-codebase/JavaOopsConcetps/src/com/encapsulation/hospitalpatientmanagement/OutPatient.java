package com.encapsulation.hospitalpatientmanagement;

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;

    public OutPatient(int id, String name, int age, double fee) {
        super(id, name, age);
        this.consultationFee = fee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        addMedicalRecord(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Out-Patient Medical History:");
        showMedicalHistory();
    }
}
