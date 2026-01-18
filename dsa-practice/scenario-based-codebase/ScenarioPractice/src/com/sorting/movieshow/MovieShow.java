package com.sorting.movieshow;

import java.time.LocalTime;

public class MovieShow {
	String movieName;
	LocalTime time;
	
	public MovieShow(String movieName, LocalTime time) {
		this.movieName = movieName;
		this.time = time;
	}
	
	public String toString() {
		return "Movie Name: " + movieName + " || Movie Time: " + time;
	}
}
