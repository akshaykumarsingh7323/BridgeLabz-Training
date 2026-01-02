package com.stockmanagementsystem;

import java.util.*;

public class InventoryManager {

    private Map<String, InventoryItem> stock = new HashMap<>();

    public void addProduct(Product p, int quantity) {
        InventoryItem item = new InventoryItem(p, quantity);
        stock.put(p.getProductId(), item);
    }

    public void addStock(String productId, int quantity) {
        InventoryItem item = stock.get(productId);
        if (item != null) {
            item.addStock(quantity);
        } else {
            System.out.println("Product not found!");
        }
    }

    public void sellProduct(String productId, int quantity) {
        InventoryItem item = stock.get(productId);
        if (item != null) {
            item.reduceStock(quantity);
        } else {
            System.out.println("Product not found!");
        }
    }

    public void showInventory() {
        System.out.println("\n--- Current Inventory ---");
        for (InventoryItem item : stock.values()) {
            item.displayItem();
        }
    }
}