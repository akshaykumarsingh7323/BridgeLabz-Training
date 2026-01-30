package com.functionalinterface.digitalpayment;

public class WalletPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs " + amount + " using Wallet");
    }
}
