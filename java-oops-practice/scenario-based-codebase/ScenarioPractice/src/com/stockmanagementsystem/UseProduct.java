package com.stockmanagementsystem;

public class UseProduct {

    public static void main(String[] args) {

        InventoryManager manager = new InventoryManager();

        Product p1 = new Product("P101", "Keyboard", 850);
        Product p2 = new Product("P102", "Mouse", 450);
        Product p3 = new Product("P103", "Monitor", 9800);

        manager.addProduct(p1, 20);
        manager.addProduct(p2, 35);
        manager.addProduct(p3, 10);

        manager.showInventory();

        manager.sellProduct("P102", 5);
        manager.addStock("P103", 3);

        manager.showInventory();
    }
}