package com.inheritence.bankaccount;

class BankAccount {
 String accountNumber;
 double balance;

 BankAccount(String accountNumber, double balance) {
     this.accountNumber = accountNumber;
     this.balance = balance;
 }

 void displayDetails() {
     System.out.println("Account Number: " + accountNumber);
     System.out.println("Balance: $" + balance);
 }

 void displayAccountType() {
     System.out.println("General Bank Account");
 }
}
