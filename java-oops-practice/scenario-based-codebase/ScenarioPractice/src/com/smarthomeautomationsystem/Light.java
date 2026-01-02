package com.smarthomeautomationsystem;

public class Light extends Appliance {

    public Light(String name, int powerWatts) {
        super(name, powerWatts);
    }

    @Override
    public void turnOn() {
        setPowerState(true);
        System.out.println(name + " Light is now ON (soft glow mode)");
    }

    @Override
    public void turnOff() {
        setPowerState(false);
        System.out.println(name + " Light is now OFF");
    }

    @Override
    public void deviceInfo() {
        System.out.println("Device: Light | Name: " + name + " | Power: " + getPowerUsage() + "W");
    }
}
