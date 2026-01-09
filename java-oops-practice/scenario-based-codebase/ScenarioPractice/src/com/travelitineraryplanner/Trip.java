package com.travelitineraryplanner;

import java.util.List;

public abstract class Trip implements IBookable {

    protected String destination;
    protected int duration;
    protected double budget;

    protected Transport transport;
    protected Hotel hotel;
    protected List<Activity> activities;

    public Trip(String destination, int duration,
                Transport transport, Hotel hotel,
                List<Activity> activities) {

        this.destination = destination;
        this.duration = duration;
        this.transport = transport;
        this.hotel = hotel;
        this.activities = activities;

        calculateBudget();
    }

    protected void calculateBudget() {
        budget = transport.getCost() + hotel.getCost();
        for (Activity a : activities) {
            budget += a.getCost();
        }
    }

    public double getBudget() {
        return budget;
    }

    public abstract void book();
}
