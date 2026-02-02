package com.travellog;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Trip implements Serializable {
    private String city;
    private String country;
    private int durationInDays;
    private String notes; 

    public Trip(String city, String country, int durationInDays, String notes) {
        this.city = city;
        this.country = country;
        this.durationInDays = durationInDays;
        this.notes = notes;
    }

    public String getCity() { return city; }
    public String getCountry() { return country; }
    public int getDurationInDays() { return durationInDays; }
    public String getNotes() { return notes; }

    @Override
    public String toString() {
        return city + ", " + country + " (" + durationInDays + " days)";
    }
    
    public static void main(String[] args) throws ClassNotFoundException {
    	List<Trip> tripList = new ArrayList<>();

    	tripList.add(new Trip("Paris", "France", 7, "Eiffel tower visit"));
    	tripList.add(new Trip("Rome", "Italy", 4, "Colosseum tour"));
    	tripList.add(new Trip("Delhi", "India", 6, "Food & culture"));

    	try {
    		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("trips.dat"));

        	oos.writeObject(tripList);
        	oos.close(); 
        	
        	ObjectInputStream ois = new ObjectInputStream(new FileInputStream("trips.dat"));

        	List<Trip> trips = (List<Trip>) ois.readObject();
        	ois.close();
    	}catch(IOException e) {
    		System.out.println("You got an error");
    	}
    	
	}
}
