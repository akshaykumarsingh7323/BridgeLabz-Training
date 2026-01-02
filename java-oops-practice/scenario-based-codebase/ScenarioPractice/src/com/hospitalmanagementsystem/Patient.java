package com.hospitalmanagementsystem;

public class Patient extends Person {

    private String disease;

    public Patient(String id, String name, int age, String disease) {
        super(id, name, age);
        this.disease = disease;
    }

    public String getDisease() {
        return disease;
    }

    @Override
    public void showDetails() {
        System.out.println("\nPatient Details");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Disease: " + disease);
    }
}