package com.universityenrollmentsystem;

public class Postgraduate extends Student {

    public Postgraduate(String name, String id) {
        super(name, id);
    }

    @Override
    public void displayInfo() {
        System.out.println("Postgraduate Student -> " + getName() + " | ID: " + getStudentId());
    }
}
