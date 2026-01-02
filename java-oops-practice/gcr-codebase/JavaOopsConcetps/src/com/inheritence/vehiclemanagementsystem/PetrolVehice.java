package com.inheritence.vehiclemanagementsystem;

class PetrolVehicle extends Vehicle implements Refuelable {
    int tankCapacity; 

    PetrolVehicle(String model, int maxSpeed, int tankCapacity) {
        super(model, maxSpeed);
        this.tankCapacity = tankCapacity;
    }

    @Override
    public void refuel() {
        System.out.println(model + " is refueling. Tank capacity: " + tankCapacity + " liters");
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Tank Capacity: " + tankCapacity + " liters");
    }
}
