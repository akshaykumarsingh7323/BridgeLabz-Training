package com.smarthomedevicemanager;

class Lock extends Device {

    public Lock(String deviceId) {
        super(deviceId);
    }

    @Override
    public void turnOn() {
        setStatus(true);
        addEnergy(0.2);
        System.out.println("Lock " + deviceId + " locked");
    }

    @Override
    public void turnOff() {
        setStatus(false);
        System.out.println("Lock " + deviceId + " unlocked");
    }

    @Override
    public void reset() {
        System.out.println("Lock " + deviceId + " security reset");
    }
}
