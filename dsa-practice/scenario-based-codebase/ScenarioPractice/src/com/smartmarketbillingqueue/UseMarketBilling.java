package com.smartmarketbillingqueue;

import java.util.Arrays;

public class UseMarketBilling {
    public static void main(String[] args) {

        SmartCheckout checkout = new SmartCheckout();

        checkout.addCustomer(new Customer("Akshay",
                Arrays.asList("Milk", "Bread")));

        checkout.addCustomer(new Customer("Aman",
                Arrays.asList("Eggs", "Milk", "Eggs")));

        checkout.processCustomer();
        checkout.displayStock();

        checkout.processCustomer();
        checkout.displayStock();
    }
}

