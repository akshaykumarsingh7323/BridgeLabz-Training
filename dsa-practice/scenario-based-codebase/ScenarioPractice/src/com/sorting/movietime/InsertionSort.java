package com.sorting.movietime;

import java.util.*;

public class InsertionSort {
	void sorting(ArrayList<MovieShow>list) {
		int n = list.size();
		
		for(int i = 1; i<n; i++) {
			MovieShow key = list.get(i);
			
			int j = i-1;
			
			while (j>=0 && list.get(j).getTime().isAfter(key.getTime())) {
				list.set(j+1, list.get(j));
				j--;
			}
			j++;
			list.set(j, key);
		}
		System.out.println("\nList Sorted Successfully...\n");
	}
	
	void displayMovieList(ArrayList<MovieShow>list) {
		if(list.isEmpty()) {
			System.out.println("List is Empty");
			return;
		}
		
		for(MovieShow m : list) {
			System.out.println(m);
		}
	}
}
