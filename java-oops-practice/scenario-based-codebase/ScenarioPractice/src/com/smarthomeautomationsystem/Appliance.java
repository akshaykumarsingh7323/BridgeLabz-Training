package com.smarthomeautomationsystem;

public abstract class Appliance implements Controllable {

    private boolean powerState;
    private int powerWatts;        // internal energy rating

    protected String name;         // accessible by subclasses

    public Appliance(String name, int powerWatts) {
        this.name = name;
        this.powerWatts = powerWatts;
        this.powerState = false;   // default off
    }

    public boolean isOn() {
        return powerState;
    }

    protected void setPowerState(boolean state) {
        this.powerState = state;
    }

    public int getPowerUsage() {
        return powerWatts;
    }

    public void compareEnergy(Appliance other) {
        if (this.powerWatts > other.powerWatts)
            System.out.println(name + " consumes more energy than " + other.name);
        else if (this.powerWatts < other.powerWatts)
            System.out.println(name + " consumes less energy than " + other.name);
        else
            System.out.println(name + " and " + other.name + " consume equal energy");
    }

    public abstract void deviceInfo();
}
