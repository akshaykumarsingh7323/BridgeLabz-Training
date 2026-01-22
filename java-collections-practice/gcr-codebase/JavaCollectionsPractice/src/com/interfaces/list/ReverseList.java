package com.interfaces.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReverseList {
	
	public static <T> void reverse(List<T> list) {
		int start = 0;
		int end = list.size() - 1;
		
		while(start < end) {
			T temp = list.get(start);
			list.set(start, list.get(end));
			list.set(end, temp);
			
			start++;
			end--;
		}
	}
	public static void main(String[] args) {
		
		System.out.println("-------- ArrayList ---------\n");
		List <Integer> arraylist = new ArrayList<>();
		arraylist.add(1);
		arraylist.add(2);
		arraylist.add(3);
		arraylist.add(4);
		arraylist.add(5);
		System.out.println("Original ArrayList: " + arraylist);
		reverse(arraylist);
		System.out.println("Reverse ArrayList: " + arraylist);
		
		System.out.println("\n-------- LinkedList ---------\n");
		List <Integer> linkedlist = new LinkedList<>();
		linkedlist.add(1);
		linkedlist.add(2);
		linkedlist.add(3);
		linkedlist.add(4);
		linkedlist.add(5);
		System.out.println("Original LinkedList: " + linkedlist);
		reverse(linkedlist);
		System.out.println("Reverse LinkedList: " + linkedlist);
	}	
}
