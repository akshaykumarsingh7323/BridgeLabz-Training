package com.objectmodeling.ecommerce;

import java.util.*;

class Order {
    private int orderId;
    private List<Product> products;

    public Order(int orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
        System.out.println("Order created: " + orderId);
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println(product.getName() + " added to Order " + orderId);
    }

    public void showOrderDetails() {
        System.out.println("\nOrder ID: " + orderId);
        double total = 0;

        for (Product p : products) {
            System.out.println(" - " + p.getName() + " : ₹" + p.getPrice());
            total += p.getPrice();
        }

        System.out.println("Total Amount: ₹" + total);
    }
}

