package com.ewalletapplication;

import java.time.LocalDateTime;
public class Transaction {
    private User sender;
    private User receiver;
    private double amount;
    private LocalDateTime time;

    public Transaction(User sender, User receiver, double amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.time = LocalDateTime.now();
    }

    public void printTransaction() {
        System.out.println("Txn -> From: " + sender.getName()
                + " To: " + receiver.getName()
                + " Amount: " + amount
                + " | Time: " + time);
    }
}
