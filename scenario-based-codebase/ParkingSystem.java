/*
Parking Lot Gate System
Develop a smart parking system.
 Options: Park, Exit, Show Occupancy
 Use switch-case for the menu.
 while loop to continue until the parking lot is full or the user exits.
*/

import java.util.*;
public class ParkingSystem{
    public static void main(String args []){
	Scanner sc = new Scanner(System.in);
	
	boolean availability = true;
	int available = 5;
	int occupy = 0;
	System.out.println("\n-------- Parking Lot Gate System --------");
	while(availability){
	    System.out.println("1.Parking\n2.Exit\n3.Check Availability\n0.Close Parking\n");
	    System.out.println("Enter choice:");
	    int n = sc.nextInt(); 
	    switch(n){
	        case 1: {
		   if(available > occupy){
		      System.out.println("Parked successfully\n");
			occupy++;
			if(available == occupy){
			   System.out.println("All spaces occupied");
			   availability = false;
			}
		   }
			break;
		 }
		 case 2: {
		     if(occupy == 0){
			System.out.println("Your car doesn't exist!\n");
 			availability = false;
		     }else{
			System.out.println("Exit successfull\nThankyou\n");
			occupy--;
		     }
		  break;
		 }

		 case 3: {
		    System.out.println("\nOccupied: " + occupy);
		    System.out.println("Available: " + (available - occupy)+"\n");
		    break;
		 }

		 case 0 :{
		    System.out.println("Parking closed");
		    availability = false;
		    break;	
		 }
		 default : {
		    System.out.println("Invalid choice!");
		 }
	    }
	}	
    }
}