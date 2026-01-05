package com.groceryshoppingapp;

import java.util.*;

class Cart implements ICheckout {

    private List<Product> products;
    private double totalPrice;

    public Cart() {
        products = new ArrayList<>();
        totalPrice = 0;
    }

    public Cart(List<Product> items) {
        products = items;
        calculateTotal();
    }

    public void addProduct(Product p, int quantity) {
        for (int i = 0; i < quantity; i++) {
            products.add(p);
            totalPrice += p.getPrice(); 
        }
    }

    private void calculateTotal() {
        totalPrice = 0;
        for (Product p : products) {
            totalPrice += p.getPrice();
        }
    }

    @Override
    public void applyDiscount(double coupon) {
        totalPrice -= coupon; 
    }

    @Override
    public void generateBill() {
        double discount = 0;

        System.out.println("\n--- Bill Details ---");
        for (Product p : products) {
            System.out.println(p.getName() + " - Rs " + p.getPrice());
            discount += p.getDiscount(); 
        }

        double finalAmount = totalPrice - discount;

        System.out.println("Total Price: Rs " + totalPrice);
        System.out.println("Product Discount: Rs " + discount);
        System.out.println("Final Payable Amount: Rs " + finalAmount);
    }
}

