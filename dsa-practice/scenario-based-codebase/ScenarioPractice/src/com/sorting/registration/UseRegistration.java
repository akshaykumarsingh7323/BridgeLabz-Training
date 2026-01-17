package com.sorting.registration;

import java.time.LocalTime;
import java.util.Scanner;

public class UseRegistration {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArtistRegistration artists = new ArtistRegistration();
		
		
		while(true) {
			System.out.println("\nEnter 1 to view all artists");
			System.out.println("Enter 2 to add an artist");
			System.out.println("Enter 3 to sort artists");
			System.out.println("Enter 4 to exit");

			int choice = sc.nextInt();
			sc.nextLine();
			
			
			switch(choice) {
				case 1:
					artists.showArtist();
					break;
					
				case 2:
					System.out.println("Enter name: ");
					String name = sc.nextLine();
					
					System.out.println("Enter registration time: ");
					String registrationTime = sc.nextLine();
					
					LocalTime time = LocalTime.parse(registrationTime);
					
					artists.addArtist(new Artist(name, time));
					break;
					
				case 3:
					artists.insertionSort();
					break;
					
				case 4:
					System.out.println("Thank You");
					return;
					
				default: 
					System.out.println("Invalid choice");
			}
		}
		
	}
}

