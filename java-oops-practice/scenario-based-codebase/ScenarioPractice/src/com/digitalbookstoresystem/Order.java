package com.digitalbookstoresystem;

import java.util.*;

public class Order {

    private String userName;
    private Map<Book, Integer> items = new HashMap<>();
    private String status = "CREATED";

    public Order(String userName) {
        this.userName = userName;
    }

    public void addBook(Book book, int quantity) {
        if (book.reduceStock(quantity)) {
            items.put(book, quantity);
        } else {
            System.out.println("Not enough stock for " + book.title);
        }
    }

    public double calculateTotal() {
        double total = 0;

        for (Map.Entry<Book, Integer> entry : items.entrySet()) {
            Book book = entry.getKey();
            int qty = entry.getValue();

            double discount = book.applyDiscount(book.price, qty);
            total += (book.price * qty) - discount;
        }
        return total;
    }

    protected void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    public String getStatus() {
        return status;
    }
}
