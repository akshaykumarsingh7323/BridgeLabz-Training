package com.eventmanagementplatform;

import java.util.UUID;

public abstract class Event implements ISchedulable {

    private final String eventId; 
    protected String eventName;
    protected String location;
    protected String date;
    protected int attendees;
    protected User organizer;

    private double venueCost;
    private double serviceCost;
    private double discount;

    public Event(String eventName, String location, String date,
                 int attendees, User organizer, double venueCost) {

        this.eventId = UUID.randomUUID().toString();
        this.eventName = eventName;
        this.location = location;
        this.date = date;
        this.attendees = attendees;
        this.organizer = organizer;
        this.venueCost = venueCost;
        this.serviceCost = 0;
        this.discount = 0;
    }

    public Event(String eventName, String location, String date,
                 int attendees, User organizer,
                 double venueCost, double serviceCost, double discount) {

        this.eventId = UUID.randomUUID().toString();
        this.eventName = eventName;
        this.location = location;
        this.date = date;
        this.attendees = attendees;
        this.organizer = organizer;
        this.venueCost = venueCost;
        this.serviceCost = serviceCost;
        this.discount = discount;
    }

    public double calculateTotalCost() {
        return venueCost + serviceCost - discount;
    }

    public String getEventId() {
        return eventId;
    }

    public void showEventDetails() {
        System.out.println("Event ID: " + eventId);
        System.out.println("Event: " + eventName);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Attendees: " + attendees);
        System.out.println("Organizer: " + organizer.getName());
        System.out.println("Total Cost: ₹" + calculateTotalCost());
        System.out.println("---------------------------");
    }
}
