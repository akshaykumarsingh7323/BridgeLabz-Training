package com.generics.resumescreeningsystem;

class ProductManager extends JobRole {

    ProductManager(String name) {
        super(name);
    }

    String role() {
        return "Product Manager";
    }

    int score() {
        return 80;
    }
}

