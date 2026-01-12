package com.smarthomedevicemanager;

public class UseHomeDevice {
    public static void main(String[] args) {

        Device light = new Light("L101");
        Device camera = new Camera("C202");
        Device ac = new Thermostat("T303");
        Device lock = new Lock("K404");

        light.turnOn();
        camera.turnOn();
        ac.turnOn();
        lock.turnOn();

        light.reset();
        camera.reset();

        System.out.println("Camera energy usage: " + camera.getEnergyUsage());
    }
}
