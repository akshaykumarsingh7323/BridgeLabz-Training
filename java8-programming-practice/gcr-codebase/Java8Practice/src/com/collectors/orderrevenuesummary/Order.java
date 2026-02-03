package com.collectors.orderrevenuesummary;

public class Order {
    private String customerName;
    private double orderTotal;

    public Order(String customerName, double orderTotal) {
        this.customerName = customerName;
        this.orderTotal = orderTotal;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getOrderTotal() {
        return orderTotal;
    }
}
