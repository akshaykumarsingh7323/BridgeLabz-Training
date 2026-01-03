package com.bankmanagementsystem3;

public class UseBank {

    public static void main(String[] args) {

        Account acc1 = new SavingsAccount("SB101", 10000);
        Account acc2 = new CurrentAccount("CA201");

        acc1.deposit(2000);
        acc1.calculateInterest();
        System.out.println("Savings Balance: " + acc1.checkBalance());

        System.out.println();

        acc2.deposit(5000);
        acc2.withdraw(1500);
        acc2.calculateInterest();
        System.out.println("Current Balance: " + acc2.checkBalance());
    }
}
