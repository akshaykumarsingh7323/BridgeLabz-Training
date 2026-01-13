package com.trafficmanager;

public class UseTrafficManager {
    public static void main(String[] args) {

        TrafficManager tm = new TrafficManager();

        tm.addVehicle("CAR-101");
        tm.addVehicle("CAR-102");
        tm.addVehicle("CAR-103");
        tm.addVehicle("CAR-104");
        tm.addVehicle("CAR-105");

        tm.displayRoundabout();
        tm.displayQueue();

        tm.removeVehicle("CAR-102");

        tm.displayRoundabout();
        tm.displayQueue();
    }
}
