package com.avltree.onlineticketbooking;

public class UseTicketBooking {

    public static void main(String[] args) {

        EventBST bookingSystem = new EventBST();

        bookingSystem.insert(1800, "Rock Concert");
        bookingSystem.insert(1400, "Tech Conference");
        bookingSystem.insert(2000, "Comedy Show");
        bookingSystem.insert(1100, "Morning Yoga");
        bookingSystem.insert(1600, "Movie Premiere");

        System.out.println("Upcoming Events:");
        bookingSystem.showUpcomingEvents();

        System.out.println("\nCancelling event at 16:00");
        bookingSystem.delete(1600);

        System.out.println("\nUpdated Events:");
        bookingSystem.showUpcomingEvents();
    }
}
