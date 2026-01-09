package com.pharmacyinventorysalessystem;

import java.time.LocalDate;

public class Tablet extends Medicine {

    public Tablet(String name, double price, LocalDate expiryDate, int quantity) {
        super(name, price, expiryDate, quantity);
    }

    @Override
    public boolean checkExpiry() {
        return LocalDate.now().isAfter(expiryDate);
    }
}
