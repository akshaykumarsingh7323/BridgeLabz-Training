package com.constructor.level1;

// Hotel Booking System: Create a HotelBooking class with attributes guestName, roomType, and nights. Use default, parameterized, and copy constructors to initialize bookings.
public class HotelBooking {
	String guestName;
	String roomType;
	int nights;
	
	HotelBooking(){
		this("Akshay", "Standard", 1);
	}
	
	HotelBooking(String guestName, String roomType, int nights ){
		this.guestName = guestName;
		this.roomType = roomType;
		this.nights = nights;
	}
	
	HotelBooking(HotelBooking hb){
		this.guestName = hb.guestName;
		this.roomType = hb.roomType;
		this.nights = hb.nights;
	}
	
	void display() {
		System.out.println("Guest name: " + guestName + ", Room Type: " + roomType + ", Night: " + nights);
	}
}
