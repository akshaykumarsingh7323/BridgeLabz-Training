package com.smarthomedevicemanager;

abstract class Device implements IControllable {

    protected String deviceId;
    private boolean status;         
    protected double energyUsage;  

    protected String firmwareLog;

    public Device(String deviceId) {
        this.deviceId = deviceId;
        this.status = false;
        this.energyUsage = 0;
        this.firmwareLog = "Firmware v1.0 installed";
    }

    public boolean isOn() {
        return status;
    }

    protected void setStatus(boolean status) {
        this.status = status;
    }

    public double getEnergyUsage() {
        return energyUsage;
    }

    protected void addEnergy(double units) {
        energyUsage += units;
    }
}

