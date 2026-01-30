package com.lambdaexpression.ecommercesorting;

import java.util.*;

public class EcommerceSorting {

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        products.add(new Product("Laptop", 55000, 4.5, 10));
        products.add(new Product("Mobile", 25000, 4.2, 15));
        products.add(new Product("Headphones", 3000, 4.8, 25));
        products.add(new Product("Smart Watch", 8000, 4.1, 20));

        // Sort by Price
        products.sort((p1, p2) -> Double.compare(p1.price, p2.price));
        System.out.println("Sorted by Price:");
        products.forEach(System.out::println);
//        products.forEach(product -> System.out.println(product));

        // Sort by Rating
        products.sort((p1, p2) -> Double.compare(p2.rating, p1.rating));
        System.out.println("\nSorted by Rating:");
        products.forEach(System.out::println);

        // Sort by Discount
        products.sort((p1, p2) -> Double.compare(p2.discount, p1.discount));
        System.out.println("\nSorted by Discount:");
        products.forEach(System.out::println);
    }
}

