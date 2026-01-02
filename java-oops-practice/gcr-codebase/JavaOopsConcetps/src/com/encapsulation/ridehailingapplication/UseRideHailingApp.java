package com.encapsulation.ridehailingapplication;

import java.util.*;

public class UseRideHailingApp {

    public static void calculateRideFare(Vehicle vehicle, double distance) {
        vehicle.getVehicleDetails();
        System.out.println("Distance: " + distance + " km");
        System.out.println("Total Fare: ₹" + vehicle.calculateFare(distance));
        System.out.println("--------------------------------");
    }

    public static void main(String[] args) {

        Vehicle car = new Car("CAR101", "Amit", 15);
        Vehicle bike = new Bike("BIKE202", "Rohit", 10);
        Vehicle auto = new Auto("AUTO303", "Suresh", 12);

        calculateRideFare(car, 10);
        calculateRideFare(bike, 10);
        calculateRideFare(auto, 10);
    }
}
