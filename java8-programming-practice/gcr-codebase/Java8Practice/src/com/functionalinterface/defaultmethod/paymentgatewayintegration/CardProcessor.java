package com.functionalinterface.defaultmethod.paymentgatewayintegration;

class CardProcessor implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs " + amount + " using Credit Card");
    }
}
