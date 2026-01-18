package com.sorting.quicksort;

import java.util.Scanner;

public class UseEventManager {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TicketPriceAnalyzer analyzer = new TicketPriceAnalyzer();
		System.out.println("Enter number of tickets");
		int n = sc.nextInt();
		
		Ticket [] tickets = new Ticket[n];
		
		System.out.println("Enter ticket price: ");
		for(int i = 0; i < n; i++) {
			tickets[i] = new Ticket(sc.nextDouble());
		}
		
		analyzer.sortTickets(tickets);
		int choice;
				
		do {
			System.out.println("Enter 0 to exit");
			System.out.println("Enter 1 to check cheapest ticket");
			System.out.println("Enter 1 to check cheapest ticket");
			choice = sc.nextInt();
			switch(choice) {
			    case 0:{
			    	System.out.println("Thank You");
			    	return;
			    }
				case 1: {
					analyzer.displayCheapestTickets(tickets, 50);
					System.out.println();
					break;
				}
				case 2: {
					analyzer.displayExpensiveTicket(tickets, 50);
					System.out.println();
					break;
				}
				default: {
					System.out.println("Invalid Choice!");
					return;
				}
			}
		}while(choice != 0);
	}
}
