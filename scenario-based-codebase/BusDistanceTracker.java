/*
	19. Bus Route Distance Tracker 🚌
	Each stop adds distance.
	● Ask if the passenger wants to get off at a stop.
	● Use a while-loop with a total distance tracker.
	● Exit on user confirmation.
*/

import java.util.*;
public class BusDistanceTracker{
    public static void main(String args []){
	    Scanner sc = new Scanner(System.in);
		
		System.out.println("\n----------------------------------");
		System.out.println("------ Bus Distance Tracker ------");
		System.out.println("----------------------------------\n");

		int distance [] = {0, 10, 9, 13, 17, 12, 16, 15, 24};
		int cost [] = {0, 20, 20, 30, 45, 40, 45, 40, 60};
		int totalCost = 0;
		int totalDistance = 0;
		int index = 0;
		boolean choise = true;
		
		while(choise){
			System.out.print("You are on the stopies " + (index + 1) + "," + " Do yo want to get off ?: ");
			totalCost = totalCost + cost[index];
		    totalDistance = totalDistance + distance[index];
			index++;
			char ch = sc.next().trim().toLowerCase().charAt(0);
			
			while(!(ch == 'y' || ch == 'n')){
				System.out.print("\nPlease enter a valid input (yes/no): ");
				ch = sc.next().trim().toLowerCase().charAt(0);
			}
			
			if(ch == 'y'){
				choise = false;
			}
			
			if(index == 9 ){
				System.out.println("\nYou are on the last stopies");
				choise = false;
			}
			System.out.println("");
		}
		    System.out.println("Distance Covered: " + "Rs " + totalDistance + "km");
			System.out.println("Total Fare: " + "Rs " + totalCost);
			
			System.out.println("\n-----------");
			System.out.println(" Thank you");
			System.out.println("-----------");
	}
}