package com.sorting.registration;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArtistRegistration {
	static List<Artist> artist = new ArrayList<>(); 
	
	
	// Add Artist
	public void addArtist(Artist newArtist) {
		artist.add(newArtist);
		System.out.println("Artist added");
	}
	
	
	// Sort artist
	public static void insertionSort() {
        int n = artist.size(); 

        for(int i=1; i<n; i++) {
        	Artist top = artist.get(i);
        	int j = i-1;
        	
        	while(j >=0 && artist.get(j).getTime().isAfter(top.getTime())) {
        		artist.set(j+1, artist.get(j));
        		j--;
        	}
        	
        	j++;
        	artist.set(j, top);
        }
        
        System.out.println("Artist sorted successfully");
    }
	
	
	// Show artists
	public void showArtist() {
		if(artist.isEmpty()) {
			System.out.println("Empty Artist");
			return;
		}
		
		for(Artist at : artist) {
			System.out.println(at);
		}
	}
}
