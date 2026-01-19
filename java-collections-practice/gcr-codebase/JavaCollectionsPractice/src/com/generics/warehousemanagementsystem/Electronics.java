package com.generics.warehousemanagementsystem;

class Electronics extends WarehouseItem {
    public Electronics(String name) {
        super(name);
    }

    @Override
    void displayInfo() {
        System.out.println("Electronics Item: " + getName());
    }
}

