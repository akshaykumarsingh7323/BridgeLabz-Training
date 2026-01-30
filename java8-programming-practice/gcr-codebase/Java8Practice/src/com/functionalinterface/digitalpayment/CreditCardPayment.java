package com.functionalinterface.digitalpayment;

public class CreditCardPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs " + amount + " using Credit Card");
    }
}

