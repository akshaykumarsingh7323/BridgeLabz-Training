package com.ridehailingapp;

class Driver {

    private String name;
    private String licenseNumber;
    private double rating;

    public Driver(String name, String licenseNumber, double rating) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.rating = rating;
    }

    public String getDriverDetails() {
        return "Driver Name: " + name +
               ", License: " + licenseNumber;
    }

    public double getRating() {
        return rating;
    }
}
