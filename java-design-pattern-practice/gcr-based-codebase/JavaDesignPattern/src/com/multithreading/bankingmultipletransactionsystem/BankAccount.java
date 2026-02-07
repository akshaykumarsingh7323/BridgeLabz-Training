package com.multithreading.bankingmultipletransactionsystem;

import java.time.LocalDateTime;

class BankAccount {

    private int balance = 10000;

    public int getBalance() {
        return balance;
    }

    public boolean withdraw(String customerName, int amount) {

        System.out.println("[" + customerName + "] Attempting to withdraw " + amount);

        if (balance >= amount) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            balance = balance - amount;

            System.out.println("Transaction successful: " +
                    customerName +
                    ", Amount: " + amount +
                    ", Balance: " + balance +
                    ", Time: " + LocalDateTime.now());
            return true;
        } else {
            System.out.println("Transaction FAILED: " +
                    customerName +
                    ", Amount: " + amount +
                    ", Balance: " + balance +
                    ", Time: " + LocalDateTime.now());
            return false;
        }
    }
}
