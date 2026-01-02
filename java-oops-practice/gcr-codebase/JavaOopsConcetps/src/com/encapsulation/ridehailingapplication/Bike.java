package com.encapsulation.ridehailingapplication;

class Bike extends Vehicle implements GPS {
    private String currentLocation;

    public Bike(String id, String driver, double rate) {
        super(id, driver, rate);
        this.currentLocation = "Not Available";
    }

    @Override
    public double calculateFare(double distance) {
        return ratePerKm * distance * 0.9; 
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
	