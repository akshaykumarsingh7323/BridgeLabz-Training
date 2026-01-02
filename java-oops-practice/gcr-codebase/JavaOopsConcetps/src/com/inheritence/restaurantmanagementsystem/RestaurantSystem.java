package com.inheritence.restaurantmanagementsystem;

public class RestaurantSystem {
    public static void main(String[] args) {

    	Worker chef = new Chef("Gordon", 101, "Pasta");
        Worker waiter = new Waiter("Alice", 201, "VIP Section");

        chef.performDuties();
        waiter.performDuties();

        ((Person) chef).displayInfo();
        ((Person) waiter).displayInfo();
    }
}
