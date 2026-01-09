package com.pharmacyinventorysalessystem;

import java.time.LocalDate;

public abstract class Medicine implements ISellable {

    protected String name;
    protected double price;
    protected LocalDate expiryDate;
    private int quantity;          
    private double costPrice;      

    public Medicine(String name, double price, LocalDate expiryDate) {
        this(name, price, expiryDate, 100);
    }

    public Medicine(String name, double price, LocalDate expiryDate, int quantity) {
        this.name = name;
        this.price = price;
        this.expiryDate = expiryDate;
        this.quantity = quantity;
        this.costPrice = price * 0.6;
    }

    protected boolean reduceStock(int units) {
        if (units <= quantity) {
            quantity -= units;
            return true;
        }
        return false;
    }

    public int getQuantity() {
        return quantity;
    }

    private double calculateDiscount(int units) {
        return units >= 10 ? price * units * 0.10 : 0;
    }

    public double sell(int units) {
        if (!checkExpiry() && reduceStock(units)) {
            double total = price * units;
            double discount = calculateDiscount(units);
            return total - discount;
        }
        return 0;
    }

    public abstract boolean checkExpiry();
}
