package com.linkedlist.circularlinkedlist.onlineticketreservationsystem;

public class UseTicketReservation {
    public static void main(String[] args) {

        TicketReservationSystem system = new TicketReservationSystem();

        system.addTicket(new Ticket(101, "Alice", "Inception", "A1", "10:00 AM"));
        system.addTicket(new Ticket(102, "Bob", "Inception", "A2", "10:01 AM"));
        system.addTicket(new Ticket(103, "Charlie", "Interstellar", "B1", "10:05 AM"));

        System.out.println("All Booked Tickets:");
        system.displayTickets();

        System.out.println("\nSearch by Customer Name (Alice):");
        system.searchByCustomerName("Alice");

        System.out.println("\nSearch by Movie Name (Inception):");
        system.searchByMovieName("Inception");

        system.removeTicket(102);

        System.out.println("\nAfter Removing Ticket ID 102:");
        system.displayTickets();

        System.out.println("\nTotal Tickets Booked: " + system.countTickets());
    }
}
