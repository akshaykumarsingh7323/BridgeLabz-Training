package com.constructor.level1;

public class UseCarRental {
	public static void main(String[] args) {
        CarRental r1 = new CarRental();
        CarRental r2 = new CarRental("Akshay", "SUV", 5);

        r1.display();
        r2.display();
    }
}
