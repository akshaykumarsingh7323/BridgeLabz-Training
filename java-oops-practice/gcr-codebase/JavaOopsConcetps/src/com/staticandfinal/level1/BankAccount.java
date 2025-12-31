package com.staticandfinal.level1;

public class BankAccount {
	  
	   private static String bankName = "State bank of India";
	   private static int totalAccounts = 0;
	   
	   private final String accountNumber;
	   private String accountHolderName;
	   private double balance;
	   
	   public BankAccount(String accountHolderName, String accountNumber, double balance) {
	       this.accountHolderName = accountHolderName;
	       this.accountNumber = accountNumber;
	       this.balance = balance;
	       totalAccounts++;   
	   }
	  
	   public static void getTotalAccounts() {
	       System.out.println("\nTotal number of accounts: " + totalAccounts);
	   }
	   
	   public void displayAccountDetails() {
	       
	       if (this instanceof BankAccount) {
	           System.out.println("Bank Name: " + bankName);
	           System.out.println("Account Holder: " + accountHolderName);
	           System.out.println("Account Number: " + accountNumber);
	           System.out.println("Balance: Rs " + balance);
	       } else {
	           System.out.println("Invalid account instance.");
	       }
	   }
	 
	   public String getAccountHolderName() {
	       return accountHolderName;
	   }
	   public void setAccountHolderName(String accountHolderName) {
	       this.accountHolderName = accountHolderName;
	   }
	   public double getBalance() {
	       return balance;
	   }
	   public void deposit(double amount) {
	       if (amount > 0) {
	           balance += amount;
	           System.out.println("Deposited: Rs " + amount);
	       } else {
	           System.out.println("Invalid deposit amount.");
	       }
	   }
	   public void withdraw(double amount) {
	       if (amount > 0 && amount <= balance) {
	           balance -= amount;
	           System.out.println("Withdrawn: Rs " + amount);
	       } else {
	           System.err.println("Insufficient balance or invalid amount.");
	       }
	   }
	}
