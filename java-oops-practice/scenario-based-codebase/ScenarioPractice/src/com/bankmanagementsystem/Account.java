package com.bankmanagementsystem;

abstract class Account {
 protected int accountNumber;
 protected double balance;

 public Account(int accountNumber, double balance) {
     this.accountNumber = accountNumber;
     this.balance = balance;
 }

 public void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
         System.out.println("Deposited: Rs " + amount);
     } else {
         System.out.println("Invalid deposit amount");
     }
 }

 public void withdraw(double amount) {
     if (amount > 0 && amount <= balance) {
         balance -= amount;
         System.out.println("Withdrawn: Rs " + amount);
     } else {
         System.out.println("Insufficient balance or invalid amount");
     }
 }

 public double getBalance() {
     return balance;
 }

 public abstract void calculateInterest();
}

