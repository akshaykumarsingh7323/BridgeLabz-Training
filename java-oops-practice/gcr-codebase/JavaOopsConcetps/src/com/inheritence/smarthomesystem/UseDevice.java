package com.inheritence.smarthomesystem;

public class UseDevice {
    public static void main(String[] args) {

        Thermostat t1 = new Thermostat("THERMO-101", true, 24.5);
        Thermostat t2 = new Thermostat("THERMO-102", false, 20.0);

        t1.displayStatus();
        System.out.println("------------------");
        t2.displayStatus();
    }
}
