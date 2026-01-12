package com.restaurantorderingsystem;

public class UseFoodLoop {
    public static void main(String[] args) {

        FoodItem pizza = new VegItem("Cheese Pizza", 250, 5);
        FoodItem burger = new NonVegItem("Chicken Burger", 180, 3);
        FoodItem fries = new VegItem("French Fries", 120, 10);

        Order order = new Order(); 

        order.addItem(pizza);
        order.addItem(burger);
        order.addItem(fries);

        order.placeOrder();
    }
}
