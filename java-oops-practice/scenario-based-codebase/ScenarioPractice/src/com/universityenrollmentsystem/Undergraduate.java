package com.universityenrollmentsystem;

public class Undergraduate extends Student {

    public Undergraduate(String name, String id) {
        super(name, id);
    }

    @Override
    public void displayInfo() {
        System.out.println("Undergraduate Student -> " + getName() + " | ID: " + getStudentId());
    }
}
