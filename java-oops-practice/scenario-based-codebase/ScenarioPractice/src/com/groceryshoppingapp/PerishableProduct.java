package com.groceryshoppingapp;

class PerishableProduct extends Product {

    public PerishableProduct(String name, double price) {
        super(name, price, "Perishable");
    }

    @Override
    public double getDiscount() {
        return price * 0.10; 
    }
}
