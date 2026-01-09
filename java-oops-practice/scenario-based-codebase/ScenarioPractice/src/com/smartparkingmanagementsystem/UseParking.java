package com.smartparkingmanagementsystem;

public class UseParking {

    public static void main(String[] args) {

        ParkingSlot slot1 = new ParkingSlot(101, "Zone A", "Car");
        ParkingSlot slot2 = new ParkingSlot(102, "Zone B", "Bike");

        Vehicle car = new Car("KA01AB1234");
        Vehicle bike = new Bike("KA02XY5678");

        ParkingManager manager = new ParkingManager();

        manager.parkVehicle(slot1, car);
        manager.parkVehicle(slot2, bike);

        System.out.println("Car Charges (7 hrs): Rs " + car.calculateCharges(7));
        System.out.println("Bike Charges (8 hrs): Rs " + bike.calculateCharges(8));

        manager.showLogs();

        manager.unparkVehicle(slot1);
    }
}
