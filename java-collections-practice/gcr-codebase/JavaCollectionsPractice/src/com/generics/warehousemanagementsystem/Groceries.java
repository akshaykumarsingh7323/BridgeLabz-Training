package com.generics.warehousemanagementsystem;

class Groceries extends WarehouseItem {
    public Groceries(String name) {
        super(name);
    }

    @Override
    void displayInfo() {
        System.out.println("Grocery Item: " + getName());
    }
}
