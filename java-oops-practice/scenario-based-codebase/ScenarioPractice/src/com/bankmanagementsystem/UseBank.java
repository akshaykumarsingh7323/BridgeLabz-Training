package com.bankmanagementsystem;

//Main class
public class UseBank {
 public static void main(String[] args) {

     Account savings = new SavingAccount(101, 10000, 5);
     Customer c1 = new Customer("Akshay", savings);
     c1.performTransactions();

     Account current = new CurrentAccount(102, 8000);
     Customer c2 = new Customer("Rahul", current);
     c2.performTransactions();
 }
}

