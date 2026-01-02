package com.vehiclerentalapplication;

public class UseVehicle {

    public static void main(String[] args) {

        Customer c1 = new Customer("C101", "Amit Sharma");
        c1.displayCustomer();
        System.out.println("----------------");

        Vehicle v1 = new Bike("B201", "Honda Shine", 400, true);
        Vehicle v2 = new Car("C301", "Hyundai Verna", 1800, true);
        Vehicle v3 = new Truck("T401", "Tata LPT", 3500, 8);

        rentVehicle(v1, 6);
        rentVehicle(v2, 3);
        rentVehicle(v3, 4);
    }

    // Helper method → demonstrates polymorphism
    public static void rentVehicle(Vehicle vehicle, int days) {
        vehicle.displayInfo();
        double amount = vehicle.calculateRent(days);
        System.out.println("Days Rented: " + days);
        System.out.println("Total Rent: " + amount);
        System.out.println("----------------");
    }
}
