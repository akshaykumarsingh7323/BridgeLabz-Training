package com.encapsulationonlinefooddeliverysystem;

import java.util.*;

public class UseFoodDelivery {

    public static void processOrder(List<FoodItem> items) {
        double grandTotal = 0;

        for (FoodItem item : items) {
            item.getItemDetails();

            double total = item.calculateTotalPrice();
            System.out.println("Total Price: ₹" + total);

            if (item instanceof Discountable) {
                Discountable d = (Discountable) item;
                double discount = d.applyDiscount();
                System.out.println(d.getDiscountDetails());
                System.out.println("Discount: ₹" + discount);
                total -= discount;
            }

            System.out.println("Final Price: ₹" + total);
            grandTotal += total;

            System.out.println("----------------------------");
        }

        System.out.println("Grand Total Amount: ₹" + grandTotal);
    }

    public static void main(String[] args) {

        List<FoodItem> order = new ArrayList<>();

        order.add(new VegItem("Paneer Burger", 150, 2));
        order.add(new NonVegItem("Chicken Pizza", 300, 1));

        processOrder(order);
    }
}
