package com.functionalinterface.defaultmethod.smartvehicledashboard;

public class UseVehicle {

    public static void main(String[] args) {

        Vehicle car = new Car();
        car.displaySpeed();
        car.displayBatteryPercentage(); 

        System.out.println();

        Vehicle ev = new ElectricCar();
        ev.displaySpeed();
        ev.displayBatteryPercentage();
    }
}
