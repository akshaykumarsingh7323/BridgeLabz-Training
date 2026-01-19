package com.generics.resumescreeningsystem;

class DataScientist extends JobRole {

    DataScientist(String name) {
        super(name);
    }

    String role() {
        return "Data Scientist";
    }

    int score() {
        return 90;
    }
}
