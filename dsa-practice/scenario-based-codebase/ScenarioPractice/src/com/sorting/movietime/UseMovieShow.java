package com.sorting.movietime;

import java.time.LocalTime;
import java.util.*;

public class UseMovieShow {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		InsertionSort insertion = new InsertionSort();
		ArrayList<MovieShow> list = new ArrayList<>();
		
		int choice;
		while(true) {
			System.out.println("Enter 1 to Display Movie list");
			System.out.println("Enter 2 to Add Movie in list");
			System.out.println("Enter 3 to Sort Movie");
			System.out.println("Enter 0 to Exit");
			
			choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				insertion.displayMovieList(list);
				System.out.print("\n");
				break;
				
			case 2: 
				System.out.print("\nEnter movie name: ");
				String name = sc.nextLine();
				System.out.print("Enter movie time: ");
				LocalTime time = LocalTime.parse(sc.nextLine());
				list.add(new MovieShow(name, time));
				System.out.print("\n");
				break;
				
			case 3:
				insertion.sorting(list);
				break;
				
			default : System.out.println("Invalid Choice !!!");	
			}
		}
	}
}
