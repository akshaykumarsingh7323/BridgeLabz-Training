package com.constructor.level1;

public class BankAccount {

    public String accountNumber;
    protected String accountHolder;
    private double balance;

    BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double amount) {
        if (amount >= 0) {
            this.balance = amount;
        } else {
            System.out.println("Balance cannot be negative!");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    void displayAccount() {
        System.out.println(
            "Account No: " + accountNumber +
            ", Holder: " + accountHolder +
            ", Balance: Rs" + balance
        );
    }
}

class SavingsAccount extends BankAccount {

    double interestRate;

    SavingsAccount(String accountNumber, String accountHolder,
                   double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    void displaySavingsDetails() {
        System.out.println(
            "Account No: " + accountNumber +   
            ", Holder: " + accountHolder +    
            ", Interest Rate: " + interestRate + "%"
        );
        System.out.println("Balance: Rs " + getBalance());
    }
}

