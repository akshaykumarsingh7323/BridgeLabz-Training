package com.linkedlist.singlylinkedlist.inventorymanagementsystem;

public class UseInventory {
    public static void main(String[] args) {

        InventoryList inventory = new InventoryList();

        inventory.addAtEnd(new Item(101, "Laptop", 5, 50000));
        inventory.addAtEnd(new Item(102, "Mouse", 20, 500));
        inventory.addAtBeginning(new Item(103, "Keyboard", 10, 1500));
        inventory.addAtPosition(2, new Item(104, "Monitor", 7, 12000));

        System.out.println("Inventory:");
        inventory.display();

        inventory.updateQuantity(102, 25);

        System.out.println("\nAfter Update:");
        inventory.display();

        System.out.println("\nTotal Inventory Value: ₹" + inventory.calculateTotalInventoryValue());

        System.out.println("\nSorted by Price (Ascending):");
        inventory.sortByPrice(true);
        inventory.display();

        System.out.println("\nSorted by Name (Descending):");
        inventory.sortByName(false);
        inventory.display();
    }
}
