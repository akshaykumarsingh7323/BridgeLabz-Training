package com.functionalinterface.defaultmethod.smartvehicledashboard;

interface Vehicle {

    void displaySpeed();

    default void displayBatteryPercentage() {
    }
}

