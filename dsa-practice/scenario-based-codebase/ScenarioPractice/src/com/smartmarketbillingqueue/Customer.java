package com.smartmarketbillingqueue;

import java.util.List;

class Customer {
    String name;
    List<String> items;

    public Customer(String name, List<String> items) {
        this.name = name;
        this.items = items;
    }
}
