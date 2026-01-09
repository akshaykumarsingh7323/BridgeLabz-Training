package com.travelitineraryplanner;

import java.util.*;

public class UseTourMate {

    public static void main(String[] args) {

        Transport flight = new Transport("Flight", 25000);
        Hotel hotel = new Hotel("Sea View Resort", 4000, 5);

        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity("Scuba Diving", 5000));
        activities.add(new Activity("City Tour", 2000));

        Trip trip1 = new DomesticTrip(
                "Goa", 6, flight, hotel, activities);

        Trip trip2 = new InternationalTrip(
                "Bali", 7, flight, hotel, activities);

        trip1.book();
        trip2.book();
    }
}
