package com.linkedlist.circularlinkedlist.onlineticketreservationsystem;

class TicketReservationSystem {
    private Ticket head = null;


    public void addTicket(Ticket newTicket) {
        if (head == null) {
            head = newTicket;
            newTicket.next = head;
            return;
        }

        Ticket temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newTicket;
        newTicket.next = head;
    }


    public void removeTicket(int ticketId) {
        if (head == null) return;

        Ticket curr = head, prev = null;

        do {
            if (curr.ticketId == ticketId) {

                if (curr == head && curr.next == head) {
                    head = null;
                }
                else if (curr == head) {
                    Ticket last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                }
                else {
                    prev.next = curr.next;
                }
                return;
            }

            prev = curr;
            curr = curr.next;

        } while (curr != head);
    }


    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket temp = head;
        do {
            System.out.println(
                "Ticket ID: " + temp.ticketId +
                ", Customer: " + temp.customerName +
                ", Movie: " + temp.movieName +
                ", Seat: " + temp.seatNumber +
                ", Time: " + temp.bookingTime
            );
            temp = temp.next;
        } while (temp != head);
    }


    public void searchByCustomerName(String customerName) {
        if (head == null) return;

        Ticket temp = head;
        boolean found = false;

        do {
            if (temp.customerName.equalsIgnoreCase(customerName)) {
                printTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No ticket found for customer: " + customerName);
    }

    public void searchByMovieName(String movieName) {
        if (head == null) return;

        Ticket temp = head;
        boolean found = false;

        do {
            if (temp.movieName.equalsIgnoreCase(movieName)) {
                printTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No tickets found for movie: " + movieName);
    }

    private void printTicket(Ticket t) {
        System.out.println(
            "Ticket ID: " + t.ticketId +
            ", Customer: " + t.customerName +
            ", Movie: " + t.movieName +
            ", Seat: " + t.seatNumber +
            ", Time: " + t.bookingTime
        );
    }


    public int countTickets() {
        if (head == null) return 0;

        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }
}

