package com.functionalinterface.defaultmethod.paymentgatewayintegration;

class UpiProcessor implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs " + amount + " using UPI");
    }
}
