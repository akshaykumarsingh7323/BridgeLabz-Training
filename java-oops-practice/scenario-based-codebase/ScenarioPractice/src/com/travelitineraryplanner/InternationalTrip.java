package com.travelitineraryplanner;

import java.util.List;

public class InternationalTrip extends Trip {

    public InternationalTrip(String destination, int duration,
                             Transport transport, Hotel hotel,
                             List<Activity> activities) {
        super(destination, duration, transport, hotel, activities);
    }

    @Override
    public void book() {
        System.out.println("International trip booked to " + destination);
        System.out.println("Passport & Visa verified");
        System.out.println("Budget: ₹" + budget);
    }

    @Override
    public void cancel() {
        System.out.println("International trip cancelled (refund charges apply)");
    }
}

