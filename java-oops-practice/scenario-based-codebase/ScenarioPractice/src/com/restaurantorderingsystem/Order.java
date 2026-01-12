package com.restaurantorderingsystem;

import java.util.ArrayList;

class Order implements IOrderable {

    private ArrayList<FoodItem> items;
    private double total;

    public Order() {
        items = new ArrayList<>();
        total = 0;
    }

    public void addItem(FoodItem item) {
        if (item.isAvailable()) {
            items.add(item);
            item.reduceStock();
            total += item.getPrice(); 
        } else {
            System.out.println(item.getName() + " is out of stock");
        }
    }

    public double applyDiscount() {
        if (total > 500)
            return total * 0.10;  
        else if (total > 300)
            return total * 0.05;  
        else
            return 0;
    }

    @Override
    public void placeOrder() {
        double discount = applyDiscount();
        total = total - discount; 

        System.out.println("Order placed successfully");
        System.out.println("Discount applied: Rs" + discount);
        System.out.println("Final Total: Rs " + total);
    }

    @Override
    public void cancelOrder() {
        items.clear();
        total = 0;
        System.out.println("Order cancelled");
    }
}
