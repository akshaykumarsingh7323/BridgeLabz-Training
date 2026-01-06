package com.eventmanagementplatform;

public class ConferenceEvent extends Event {

    public ConferenceEvent(String eventName, String location, String date,
                            int attendees, User organizer,
                            double venueCost, double serviceCost) {

        super(eventName, location, date, attendees, organizer,
              venueCost, serviceCost, 0);
    }

    @Override
    public void schedule() {
        System.out.println("📊 Conference scheduled with speakers & agenda.");
    }

    @Override
    public void reschedule(String newDate) {
        this.date = newDate;
        System.out.println("📅 Conference rescheduled to " + newDate);
    }

    @Override
    public void cancel() {
        System.out.println("❌ Conference booking cancelled.");
    }
}

