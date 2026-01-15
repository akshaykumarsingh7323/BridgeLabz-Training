package com.sorting.bookarrangementusinginsertionsort;

import java.util.LinkedList;
import java.util.Scanner;

public class UseInsertionSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		LinkedList <String> list = new LinkedList<>();
		String choice;
		do {
			System.out.println("Book Title to add: ");
			String title = sc.next();
			list.add(title);
			InsertionSort.insertionSort(list);
			System.out.println("\nDo you want to add more ?: (yes/no)");
			choice = sc.next();	
			while(!((choice.equalsIgnoreCase("yes")) || (choice.equalsIgnoreCase("no")))) {
				System.out.println("Please enter yes/no only!");
				choice = sc.next();
			}
			System.out.print("\n");
			
		}while(choice.equalsIgnoreCase("yes"));
	}
}
