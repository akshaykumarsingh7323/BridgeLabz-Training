package com.generics.resumescreeningsystem;

abstract class JobRole {
    String name;

    JobRole(String name) {
        this.name = name;
    }

    abstract String role();
    abstract int score();
}
