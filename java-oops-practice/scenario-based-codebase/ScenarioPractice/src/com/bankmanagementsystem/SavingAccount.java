package com.bankmanagementsystem;

class SavingAccount extends Account {
 private double interestRate;

 public SavingAccount(int accountNumber, double balance, double interestRate) {
     super(accountNumber, balance);
     this.interestRate = interestRate;
 }

 @Override
 public void calculateInterest() {
     double interest = balance * interestRate / 100;
     balance += interest;
     System.out.println("Interest added: ₹" + interest);
 }
}

