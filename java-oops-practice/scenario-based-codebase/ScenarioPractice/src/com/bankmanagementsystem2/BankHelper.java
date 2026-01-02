package com.bankmanagementsystem2;

public class BankHelper {

    public static boolean validateAmount(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Must be greater than zero.");
            return false;
        }
        return true;
    }

    public static boolean canWithdraw(double balance, double amount) {
        if (!validateAmount(amount)) return false;

        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return false;
        }
        return true;
    }

    public static double calculateInterest(double balance, double rate) {
        return balance * rate / 100;
    }

    public static boolean checkOverdraftEligibility(double balance, double limit, double amount) {
        if (!validateAmount(amount)) return false;

        if (amount > balance + limit) {
            System.out.println("Overdraft limit exceeded.");
            return false;
        }
        return true;
    }
}
