package com.smarthomedevicemanager;

class Thermostat extends Device {

    public Thermostat(String deviceId) {
        super(deviceId);
    }

    @Override
    public void turnOn() {
        setStatus(true);
        addEnergy(2.0);
        System.out.println("Thermostat " + deviceId + " regulating temperature");
    }

    @Override
    public void turnOff() {
        setStatus(false);
        System.out.println("Thermostat " + deviceId + " turned OFF");
    }

    @Override
    public void reset() {
        System.out.println("Thermostat " + deviceId + " calibration reset");
    }
}
