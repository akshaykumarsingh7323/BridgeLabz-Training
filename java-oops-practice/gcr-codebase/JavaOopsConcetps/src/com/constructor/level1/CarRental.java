package com.constructor.level1;

public class CarRental {
	String customerName;
	String carModel;
	int rentalDays;
	
	static final double RATE_PER_DAY = 1500.0;
	
	CarRental(){
		this("Aman", "Hatchback", 1);
	}
	
	CarRental(String customerName, String carModel, int rentalDays){
		this.customerName = customerName;
		this.carModel = carModel;
		this.rentalDays = rentalDays;
	}
	
	double calculateTotalCost() {
        return rentalDays * RATE_PER_DAY;
    }
	
	void display() {
		System.out.println("Customer: " + customerName + ", Car Model: " + carModel + ", Rental Days: " + rentalDays + ", Total Cost: ₹" + calculateTotalCost());
	}
}
