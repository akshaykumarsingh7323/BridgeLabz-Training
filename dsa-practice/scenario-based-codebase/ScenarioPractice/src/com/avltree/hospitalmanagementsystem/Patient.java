package com.avltree.hospitalmanagementsystem;

public class Patient {
    int checkInTime;     
    String name;
    int height;

    Patient left, right;

    public Patient(int checkInTime, String name) {
        this.checkInTime = checkInTime;
        this.name = name;
        this.height = 1;
    }
}
