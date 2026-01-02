package com.smarthomeautomationsystem;

public class AC extends Appliance {

    private int temperature;

    public AC(String name, int powerWatts, int temperature) {
        super(name, powerWatts);
        this.temperature = temperature;
    }

    @Override
    public void turnOn() {
        setPowerState(true);
        System.out.println(name + " AC is ON at " + temperature + "°C (Cooling Mode)");
    }

    @Override
    public void turnOff() {
        setPowerState(false);
        System.out.println(name + " AC is now OFF");
    }

    @Override
    public void deviceInfo() {
        System.out.println("Device: AC | Name: " + name + " | Power: "
                + getPowerUsage() + "W | Temp: " + temperature + "°C");
    }
}
