package com.inheritence.vehiclemanagementsystem;

public class VehicleManagement {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle("Tesla Model 3", 250, 75);
        PetrolVehicle pv = new PetrolVehicle("Toyota Corolla", 180, 50);

        ev.displayInfo();
        ev.charge(); 
        System.out.println("------------------------");

        pv.displayInfo();
        pv.refuel(); 
    }
}
