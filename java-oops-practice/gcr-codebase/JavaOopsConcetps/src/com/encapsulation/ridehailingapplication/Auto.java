package com.encapsulation.ridehailingapplication;

class Auto extends Vehicle implements GPS {
    private String currentLocation;

    public Auto(String id, String driver, double rate) {
        super(id, driver, rate);
        this.currentLocation = "Not Available";
    }

    @Override
    public double calculateFare(double distance) {
        return (ratePerKm * distance) + 30; 
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        currentLocation = newLocation;
    }
}
