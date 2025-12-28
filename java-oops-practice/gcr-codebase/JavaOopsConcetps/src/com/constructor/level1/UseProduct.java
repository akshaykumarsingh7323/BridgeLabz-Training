package com.constructor.level1;

public class UseProduct {
	public static void main(String[] args) {
        Product p1 = new Product("Laptop", 55000);
        Product p2 = new Product("Mouse", 799);
        Product p3 = new Product("Keyboard", 1299);

        p1.displayProductDetails();
        p2.displayProductDetails();
        p3.displayProductDetails();

        Product.displayTotalProducts(); 
    }
}
