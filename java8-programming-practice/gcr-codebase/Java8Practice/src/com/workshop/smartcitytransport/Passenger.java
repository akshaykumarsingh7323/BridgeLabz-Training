package com.workshop.smartcitytransport;

class Passenger {
    String name;
    String route;
    double fare;
    boolean peakTime;

    Passenger(String name, String route, double fare, boolean peakTime) {
        this.name = name;
        this.route = route;
        this.fare = fare;
        this.peakTime = peakTime;
    }
}
