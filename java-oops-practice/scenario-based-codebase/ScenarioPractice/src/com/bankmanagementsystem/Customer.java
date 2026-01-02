package com.bankmanagementsystem;

class Customer {
 private String name;
 private Account account;

 public Customer(String name, Account account) {
     this.name = name;
     this.account = account;
 }

 public void performTransactions() {
     System.out.println("\nCustomer: " + name);
     account.deposit(5000);
     account.withdraw(2000);
     account.calculateInterest();
     System.out.println("Final Balance: ₹" + account.getBalance());
 }
}

