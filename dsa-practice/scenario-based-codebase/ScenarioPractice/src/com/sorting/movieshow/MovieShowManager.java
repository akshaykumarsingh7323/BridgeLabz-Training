package com.sorting.movieshow;

public class MovieShowManager {
	void bubbleSort(MovieShow [] shows) {
		int n = shows.length;
		for(int i = 0; i < n - 1; i++) {
			for(int j = 0; j < n - 1 - i; j++) {
				if(shows[j].time.isAfter(shows[j + 1].time)) {
					MovieShow temp = shows[j + 1];
					shows[j + 1] = shows[j];
					shows[j] = temp;
				}
			}
		}
	}
	
	void displayAllShows(MovieShow [] shows) {
		if(shows.length == 0) {
			System.out.println("Not Available!");
		}
		for(MovieShow m : shows) {
			System.out.println(m);
		}
	}
}
