package com.healthclinic.model;

import java.sql.Date;

public class Patient {

    private int patientId;
    private String name;
    private String phone;
    private Date dob;
    private String gender;

    public Patient() {
    }

    public Patient(int patientId, String name, String phone, Date dob, String gender) {
        this.patientId = patientId;
        this.name = name;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Patient [patientId=" + patientId +
                ", name=" + name +
                ", phone=" + phone +
                ", dob=" + dob +
                ", gender=" + gender + "]";
    }
}