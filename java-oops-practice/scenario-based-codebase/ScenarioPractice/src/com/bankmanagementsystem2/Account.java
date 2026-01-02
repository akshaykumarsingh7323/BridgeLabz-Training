package com.bankmanagementsystem2;

public abstract class Account {

    protected String accountNumber;
    protected double balance;
    protected Customer customer;

    public Account(String accountNumber, double balance, Customer customer) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public abstract void withdraw(double amount);

    public void deposit(double amount) {
        if (BankHelper.validateAmount(amount)) {
            balance += amount;
            System.out.println("Deposit successful. New Balance: " + balance);
        }
    }

    public void displayAccount() {
        customer.displayCustomer();
        System.out.println("Account No: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}
