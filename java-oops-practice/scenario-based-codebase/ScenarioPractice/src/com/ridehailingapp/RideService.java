package com.ridehailingapp;

class RideService implements IRideService {

    private Driver driver;     
    private Vehicle vehicle;   
    private double fare;       
    private double distance;

    public RideService(Driver driver, Vehicle vehicle) {
        this.driver = driver;
        this.vehicle = vehicle;
    }

    @Override
    public void bookRide(double distance) {
        this.distance = distance;

        System.out.println("Ride Booked Successfully!");
        System.out.println(driver.getDriverDetails());
        System.out.println("Driver Rating: " + driver.getRating());
        System.out.println(vehicle.getVehicleDetails());

        fare = vehicle.calculateFare(distance); 
    }

    @Override
    public void endRide() {
        System.out.println("Ride Ended");
        System.out.println("Total Distance: " + distance + " km");
        System.out.println("Total Fare: Rs " + fare);
    }

    public double getFare() {
        return fare;
    }
}
