package com.smarthomedevicemanager;

class Light extends Device {

    public Light(String deviceId) {
        super(deviceId);
    }

    @Override
    public void turnOn() {
        setStatus(true);
        addEnergy(0.5);
        System.out.println("Light " + deviceId + " turned ON");
    }

    @Override
    public void turnOff() {
        setStatus(false);
        System.out.println("Light " + deviceId + " turned OFF");
    }

    @Override
    public void reset() {
        energyUsage = 0;
        System.out.println("Light " + deviceId + " reset completed");
    }
}
