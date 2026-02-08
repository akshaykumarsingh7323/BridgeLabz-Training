package com.workshop.smartcitytransport;

interface TransportService {

    String getServiceName();
    double getFare();
    String getRoute();
    int getDepartureTime(); 

    default void printServiceDetails() {
        System.out.println(getServiceName() +
                " | Route: " + getRoute() +
                " | Fare: Rs " + getFare() +
                " | Departure: " + getDepartureTime());
    }
}
