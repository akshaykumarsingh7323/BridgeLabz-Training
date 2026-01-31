package com.functionalinterface.defaultmethod.smartvehicledashboard;

class ElectricCar implements Vehicle {

    @Override
    public void displaySpeed() {
        System.out.println("Electric Car speed: 100 km/h");
    }

    @Override
    public void displayBatteryPercentage() {
        System.out.println("Battery: 75%");
    }
}
