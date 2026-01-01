package com.objectmodeling.ecommerce;

import java.util.*;

class Customer {
    private int customerId;
    private String name;
    private List<Order> orders;

    public Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public Order placeOrder(int orderId) {
        Order order = new Order(orderId);
        orders.add(order);
        System.out.println(name + " placed Order " + orderId);
        return order;
    }

    public void showOrders() {
        System.out.println("\nCustomer: " + name);
        for (Order o : orders) {
            o.showOrderDetails();
        }
    }
}

