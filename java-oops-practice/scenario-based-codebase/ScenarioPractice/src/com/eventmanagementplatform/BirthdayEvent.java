package com.eventmanagementplatform;

public class BirthdayEvent extends Event {

    public BirthdayEvent(String eventName, String location, String date,
                          int attendees, User organizer,
                          double venueCost, double serviceCost) {

        super(eventName, location, date, attendees, organizer,
              venueCost, serviceCost, 500); 
    }

    @Override
    public void schedule() {
        System.out.println("🎉 Birthday party scheduled with fun themes!");
    }

    @Override
    public void reschedule(String newDate) {
        this.date = newDate;
        System.out.println("🎂 Birthday event rescheduled to " + newDate);
    }

    @Override
    public void cancel() {
        System.out.println("❌ Birthday event cancelled.");
    }
}
