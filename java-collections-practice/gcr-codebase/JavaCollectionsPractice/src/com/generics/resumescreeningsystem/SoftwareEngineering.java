package com.generics.resumescreeningsystem;

class SoftwareEngineer extends JobRole {

    SoftwareEngineer(String name) {
        super(name);
    }

    String role() {
        return "Software Engineer";
    }

    int score() {
        return 85;
    }
}
