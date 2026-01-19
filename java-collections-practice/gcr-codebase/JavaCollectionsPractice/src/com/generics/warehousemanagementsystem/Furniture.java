package com.generics.warehousemanagementsystem;

class Furniture extends WarehouseItem {
    public Furniture(String name) {
        super(name);
    }

    @Override
    void displayInfo() {
        System.out.println("Furniture Item: " + getName());
    }
}
