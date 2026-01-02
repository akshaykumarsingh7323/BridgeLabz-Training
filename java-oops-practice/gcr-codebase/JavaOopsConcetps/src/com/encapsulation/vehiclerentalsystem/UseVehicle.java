package com.encapsulation.vehiclerentalsystem;

import java.util.*;

public class UseVehicle {
    public static void main(String[] args) {

        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("CAR101", 1500, "CAR-INS-9876"));
        vehicles.add(new Bike("BIKE202", 500, "BIKE-INS-4321"));
        vehicles.add(new Truck("TRK303", 3000, "TRK-INS-1111"));

        int days = 3;

        for (Vehicle v : vehicles) {
            System.out.println("Vehicle Type: " + v.getType());
            System.out.println("Vehicle Number: " + v.getVehicleNumber());
            System.out.println("Rental Cost for " + days + " days: ₹" +
                               v.calculateRentalCost(days));

            if (v instanceof Insurable) {
                Insurable ins = (Insurable) v;
                System.out.println("Insurance Cost: ₹" + ins.calculateInsurance());
                System.out.println(ins.getInsuranceDetails());
            }

            System.out.println("--------------------------------");
        }
    }
}
