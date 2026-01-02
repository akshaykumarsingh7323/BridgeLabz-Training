package com.stockmanagementsystem;

public class InventoryItem {

    private Product product;
    private int quantity;

    public InventoryItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addStock(int qty) {
        quantity += qty;
    }

    public void reduceStock(int qty) {
        if (qty <= quantity) {
            quantity -= qty;
        } else {
            System.out.println("Not enough stock available!");
        }
    }

    public void displayItem() {
        product.displayProduct();
        System.out.println("Stock: " + quantity);
        System.out.println("---------------------");
    }
}