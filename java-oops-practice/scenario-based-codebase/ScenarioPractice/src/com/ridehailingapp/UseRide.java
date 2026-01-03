package com.ridehailingapp;

public class UseRide {

    public static void main(String[] args) {

        Driver driver = new Driver("Ravi Kumar", "DLX12345", 4.8);

        Vehicle vehicle = new SUV("KA01AB1234");

        IRideService rideService = new RideService(driver, vehicle);

        rideService.bookRide(12.5);
        rideService.endRide();
    }
}
