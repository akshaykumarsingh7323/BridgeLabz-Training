package com.constructor.level1;

public class UseHotelBooking {

	public static void main(String[] args) {
		HotelBooking h1 = new HotelBooking();
		h1.display();
		HotelBooking h2 = new HotelBooking(h1);
		h2.display();
	}

}
