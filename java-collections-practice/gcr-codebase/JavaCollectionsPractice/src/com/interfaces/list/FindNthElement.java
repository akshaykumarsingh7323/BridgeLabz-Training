package com.interfaces.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FindNthElement {
	static void findNthElement(List<String> list, int n) {
		Iterator<String> fast = list.iterator();
		Iterator<String> slow = list.iterator();
		
		for(int i = 0; i < n; i++) {
			if(!fast.hasNext()) {
				System.out.println("Size is greater than the list size!");
				return;
			}
			fast.next();
		}
		
		while(fast.hasNext()) {
			fast.next();
			slow.next();
		}
		
		System.out.println("The Nth element from end is " + slow.next());
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List <String> list = new LinkedList<>();
		System.out.print("How many element you want to add?: ");
		int n = sc.nextInt();
		
		if(n <= 0) {
			System.out.println("Please enter a valid number!");
			return;
		}
				
		System.out.println("Enter elements: ");
		for(int i = 0; i < n; i++) {
			list.add(sc.next());
		}
		
		System.out.print("Enter Nth number: ");
		n = sc.nextInt();
		
		findNthElement(list,n);
	}
}
