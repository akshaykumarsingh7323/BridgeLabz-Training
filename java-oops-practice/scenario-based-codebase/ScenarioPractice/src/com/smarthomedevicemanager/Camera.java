package com.smarthomedevicemanager;

class Camera extends Device {

    public Camera(String deviceId) {
        super(deviceId);
    }

    @Override
    public void turnOn() {
        setStatus(true);
        addEnergy(1.2);
        System.out.println("Camera " + deviceId + " recording");
    }

    @Override
    public void turnOff() {
        setStatus(false);
        System.out.println("Camera " + deviceId + " stopped");
    }

    @Override
    public void reset() {
        firmwareLog = "Camera firmware reinstalled";
        System.out.println("Camera " + deviceId + " reset with firmware update");
    }
}
