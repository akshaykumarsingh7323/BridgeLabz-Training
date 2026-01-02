package com.bankmanagementsystem;

class CurrentAccount extends Account {

 public CurrentAccount(int accountNumber, double balance) {
     super(accountNumber, balance);
 }

 @Override
 public void calculateInterest() {
     System.out.println("No interest for Current Account");
 }
}
