package com.pharmacyinventorysalessystem;

import java.time.LocalDate;

public class Injection extends Medicine {

    public Injection(String name, double price, LocalDate expiryDate, int quantity) {
        super(name, price, expiryDate, quantity);
    }

    @Override
    public boolean checkExpiry() {
        return LocalDate.now().isAfter(expiryDate.minusDays(2));
    }
}
