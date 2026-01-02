package com.inheritence.smarthomesystem;

public class Thermostat extends Device {
    double temperatureSetting;

    Thermostat(String deviceId, boolean status, double temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    @Override
    void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting : " + temperatureSetting + " °C");
    }
}

