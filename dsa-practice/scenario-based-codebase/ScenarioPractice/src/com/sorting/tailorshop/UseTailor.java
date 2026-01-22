package com.sorting.tailorshop;

import java.time.LocalTime;
import java.util.*;
import java.util.Scanner;

public class UseTailor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List <Tailor> order = new ArrayList<>();
		TailorShop tailor = new TailorShop();
		int choice;
		while(true) {
			System.out.println("Enter 1 to Display Order");
			System.out.println("Enter 2 to Take Order");
			System.out.println("Enter 3 to Sort Order");
			System.out.println("Enter 0 to Exit");
			choice = sc.nextInt();
			sc.nextLine();
			 switch(choice) {
			 	case 1 :
			 		tailor.displayOrder(order);
			 		break;
			 	case 2 :
			 		System.out.println("Enter cloth id: ");
			 		int clothId = sc.nextInt();
			 		sc.nextLine();
			 		System.out.println("Enter deadline: ");
			 		LocalTime deadline = LocalTime.parse(sc.nextLine());
			 		order.add(new Tailor(clothId, deadline));
			 		System.out.println("Cloth added\n");
			 		break;
			 	case 3 : 
			 		tailor.insertionSort(order);
			 		System.out.println("\nOrder sorted successfuly\n");
			 		break;
			 	case 0 :
			 		System.out.println("Thankyou!, Visit again");
			 		return;
			 	default : System.out.println("Invalid Choice\n");
			 }
		}
	}
	
}
