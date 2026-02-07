package com.multithreading.bankingmultipletransactionsystem;

class Transaction implements Runnable {

    private BankAccount account;
    private String customerName;
    private int amount;

    public Transaction(BankAccount account, String customerName, int amount) {
        this.account = account;
        this.customerName = customerName;
        this.amount = amount;
    }

    @Override
    public void run() {

        System.out.println("Thread State BEFORE: " +
                Thread.currentThread().getName() +
                " -> " + Thread.currentThread().getState());

        account.withdraw(customerName, amount);
    }
}
