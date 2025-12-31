package com.staticandfinal.level1;

public class UseProduct {

	public static void main(String[] args) {
		
		   System.out.println("\n----- Shopping Cart System -----\n");
	       Product.updateDiscount(10.0); 

	       Product product1 = new Product("P001", "Laptop", 1200.00, 5);
	       Product product2 = new Product("P002", "Smartphone", 800.00, 10);

	       product1.displayProductDetails();
	       System.out.println();
	       product2.displayProductDetails();
	   }


}
