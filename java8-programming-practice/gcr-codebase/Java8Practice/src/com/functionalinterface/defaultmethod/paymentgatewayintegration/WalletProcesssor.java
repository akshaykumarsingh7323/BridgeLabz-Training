package com.functionalinterface.defaultmethod.paymentgatewayintegration;

class WalletProcessor implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs " + amount + " using Wallet");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refund of Rs " + amount + " processed to Wallet");
    }
}
