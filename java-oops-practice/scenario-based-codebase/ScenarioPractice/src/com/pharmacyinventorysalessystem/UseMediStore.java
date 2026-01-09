package com.pharmacyinventorysalessystem;

import java.time.LocalDate;

public class UseMediStore {

    public static void main(String[] args) {

        Medicine tablet = new Tablet(
                "Paracetamol", 5,
                LocalDate.of(2026, 6, 30), 200);

        Medicine syrup = new Syrup(
                "Cough Syrup", 80,
                LocalDate.of(2026, 3, 10));

        Medicine injection = new Injection(
                "Insulin", 300,
                LocalDate.of(2026, 2, 15), 50);

        System.out.println("Tablet Sale Amount: Rs " + tablet.sell(20));
        System.out.println("Syrup Sale Amount: Rs " + syrup.sell(2));
        System.out.println("Injection Sale Amount: Rs" + injection.sell(1));

        System.out.println("Tablet Stock Left: " + tablet.getQuantity());
    }
}

