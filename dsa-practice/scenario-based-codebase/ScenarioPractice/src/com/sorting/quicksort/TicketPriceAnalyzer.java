package com.sorting.quicksort;

public class TicketPriceAnalyzer {
	public void sortTickets(Ticket [] tickets) {
		QuickSort.quickSort(tickets, 0, tickets.length -1);
	}
	
	public void displayCheapestTickets(Ticket [] tickets, int count) {
		System.out.println("\nCheapest Tickets: ");
		for(int i = 0; i < Math.min(count, tickets.length); i++) {
			System.out.println(tickets[i].getPrice());
		}
	}
	
	public void displayExpensiveTicket(Ticket [] tickets, int count) {
		System.out.println("\nMost Expensive Tickets");
		for(int i = tickets.length - 1; i > Math.max(0, tickets.length - count); i--) {
			System.out.println(tickets[i].getPrice());
		}
	}
}
