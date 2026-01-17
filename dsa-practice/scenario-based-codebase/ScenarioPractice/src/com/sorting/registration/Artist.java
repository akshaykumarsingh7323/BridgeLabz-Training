package com.sorting.registration;

import java.time.LocalTime;

public class Artist {
	String name;
	LocalTime time;
	
	public Artist(String name, LocalTime time) {
		this.name = name;
		this.time = time;
	} 
	
	
	public String getName() {
		return name;
	}
	public LocalTime getTime() {
		return time;
	}


	@Override
    public String toString() {
        return "name: " + name + " || Registration time: " + time;
    }
}
