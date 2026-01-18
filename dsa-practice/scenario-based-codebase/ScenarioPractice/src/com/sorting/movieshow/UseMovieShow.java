package com.sorting.movieshow;

import java.time.LocalTime;
import java.util.Scanner;

public class UseMovieShow {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MovieShowManager manager = new MovieShowManager();
		MovieShow [] shows = new MovieShow[0];
		int choice;
		do {
			System.out.println("\nEnter 1 to show list of movie");
			System.out.println("Enter 2 to add movie");
			System.out.println("Enter 3 to sort");
			System.out.println("Enter 0 to exit");
			choice = sc.nextInt();
			
			switch(choice) {
				case 0 : {
					System.out.println("Thankyou");
					return;
				}
				case 1: {
					manager.displayAllShows(shows);
					break;
				}
				case 2: {
					System.out.println("\nEnter numbers of movie you want to add ?: ");
					int n = sc.nextInt();
					sc.nextLine();
					shows = new MovieShow[n];
					for(int i = 0; i < shows.length; i++) {
						System.out.println("Enter movie name " + (i + 1) + " :");
						String MovieName = sc.nextLine();
						System.out.println("Enter movie timing " + (i + 1) + " :");
						String MovieTiming = sc.nextLine();
						LocalTime time = LocalTime.parse(MovieTiming);
						shows[i] = new MovieShow(MovieName, time);
						System.out.println((i + 1) + " Movie added\n");
					}
					break;
				}
				case 3: {
					manager.bubbleSort(shows);
					System.out.println("Movie sorted\n");
					break;
				}
				default: System.out.println("Invalid Choice!");
			}
		}while(true);
	}
}
