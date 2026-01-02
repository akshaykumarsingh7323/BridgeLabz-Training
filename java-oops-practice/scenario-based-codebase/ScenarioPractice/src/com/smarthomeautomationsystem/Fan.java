package com.smarthomeautomationsystem;

public class Fan extends Appliance {

    private int speedLevel;

    public Fan(String name, int powerWatts, int speedLevel) {
        super(name, powerWatts);
        this.speedLevel = speedLevel;
    }

    @Override
    public void turnOn() {
        setPowerState(true);
        System.out.println(name + " Fan is ON at speed level " + speedLevel);
    }

    @Override
    public void turnOff() {
        setPowerState(false);
        System.out.println(name + " Fan is now OFF");
    }

    @Override
    public void deviceInfo() {
        System.out.println("Device: Fan | Name: " + name + " | Power: " + getPowerUsage()
                + "W | Speed: " + speedLevel);
    }
}
