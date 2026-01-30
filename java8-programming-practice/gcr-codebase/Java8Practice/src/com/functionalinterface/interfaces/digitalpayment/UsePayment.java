package com.functionalinterface.interfaces.digitalpayment;

import java.util.Scanner;

public class UsePayment {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Payment payment = null;

        System.out.println("Select Payment Method:");
        System.out.println("1. UPI");
        System.out.println("2. Credit Card");
        System.out.println("3. Wallet");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                payment = new UpiPayment();
                break;
            case 2:
                payment = new CreditCardPayment();
                break;
            case 3:
                payment = new WalletPayment();
                break;
            default:
                System.out.println("Invalid payment option");
                return;
        }

        System.out.println("Enter amount:");
        double amount = sc.nextDouble();

        payment.pay(amount);
    }
}
