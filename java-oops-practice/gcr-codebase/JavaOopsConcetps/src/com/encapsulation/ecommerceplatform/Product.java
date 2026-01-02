package com.encapsulation.ecommerceplatform;

abstract class Product {

    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public abstract double calculateDiscount();

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayProduct() {
        System.out.println("ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Base Price: ₹" + price);
    }
}
