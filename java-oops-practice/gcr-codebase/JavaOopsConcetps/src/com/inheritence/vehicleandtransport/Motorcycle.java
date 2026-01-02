package com.inheritence.vehicleandtransport;

class Motorcycle extends Vehicle {
    boolean hasGear;

    Motorcycle(int maxSpeed, String fuelType, boolean hasGear) {
        super(maxSpeed, fuelType);
        this.hasGear = hasGear;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Gear System  : " + (hasGear ? "Yes" : "No"));
        System.out.println("Vehicle Type: Motorcycle");
    }
}
