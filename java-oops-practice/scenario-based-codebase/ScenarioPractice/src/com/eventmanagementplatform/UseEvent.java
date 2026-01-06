package com.eventmanagementplatform;

public class UseEvent {

    public static void main(String[] args) {

        User user = new User("Akshay", "akshay@gmail.com");

        Event birthday = new BirthdayEvent(
                "Akshay's Birthday",
                "Banquet Hall",
                "20-Mar-2026",
                80,
                user,
                20000,
                8000
        );

        Event conference = new ConferenceEvent(
                "Tech Conference",
                "Convention Center",
                "10-Apr-2026",
                300,
                user,
                50000,
                25000
        );

        birthday.schedule();
        birthday.showEventDetails();

        conference.schedule();
        conference.reschedule("15-Apr-2026");
        conference.showEventDetails();
    }
}
