/*	
	14. Movie Ticket Booking App 
	Ask users for movie type, seat type (gold/silver), and snacks.
	● Use switch and if together.
	● Loop through multiple customers.
	● Clean structure and helpful variable names.
*/	

import java.util.*;

// create a class for booking movie ticket, seat, and snacks
public class MovieTicketBooking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char moreCustomers = 'y';

        do {
            int ticketPrice = 0;
            int snackPrice = 0;

            // Movie Type
            System.out.println("\n----- Select Movie Type ------:");
            System.out.println("1. Pushpa");
            System.out.println("2. Baaghi");
            System.out.println("3. Border");
            int movieType = sc.nextInt();

            switch (movieType) {
                case 1 -> ticketPrice = 150;
                case 2 -> ticketPrice = 250;
                case 3 -> ticketPrice = 350;
                default -> {
                    System.out.println("Invalid movie type!");
                    continue;
                }
            }

            // Seat Type
            System.out.println("\n------ Select Seat Type: ------");
            System.out.println("1. Silver");
            System.out.println("2. Gold");
            int seatType = sc.nextInt();

            if (seatType == 1) {
                ticketPrice += 50;
            } else if (seatType == 2) {
                ticketPrice += 120;
            } else {
                System.out.println("Invalid seat type!");
                continue;
            }

            // Snacks
            System.out.println("\nDo you want snacks? (y/n)");
            char snacksChoice = sc.next().charAt(0);

            if (snacksChoice == 'y' || snacksChoice == 'Y') {
                snackPrice = 100;
            }

            // Final Bill
            int totalAmount = ticketPrice + snackPrice;

            System.out.println("\n-------- Booking Summary --------\n");
            System.out.println("Ticket Price : Rs " + ticketPrice);
            System.out.println("Snack Price  : Rs " + snackPrice);
            System.out.println("Total Amount : Rs " + totalAmount);

            // Next customer
            System.out.println("\nBook ticket for next customer? (y/n)");
            moreCustomers = sc.next().trim().charAt(0);

        } while (moreCustomers == 'y' || moreCustomers == 'Y');

        System.out.println("\nThank you for using Movie Ticket Booking App 🎬");
    }
}
