package com.encapsulation.ecommerceplatform;

import java.util.*;

public class UseEccomerce {

    public static void calculateFinalPrice(List<Product> products) {

        for (Product p : products) {

            double tax = 0;

            if (p instanceof Taxable) {
                tax = ((Taxable) p).calculateTax();
            }

            double discount = p.calculateDiscount();
            double finalPrice = p.getPrice() + tax - discount;

            p.displayProduct();
            System.out.println("Discount: ₹" + discount);
            System.out.println("Tax: ₹" + tax);
            System.out.println("Final Price: ₹" + finalPrice);
            System.out.println("----------------------------");
        }
    }

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        products.add(new Electronics(101, "Laptop", 60000));
        products.add(new Clothing(102, "Jacket", 3000));
        products.add(new Groceries(103, "Rice", 1200));

        // Polymorphism in action
        calculateFinalPrice(products);
    }
}
