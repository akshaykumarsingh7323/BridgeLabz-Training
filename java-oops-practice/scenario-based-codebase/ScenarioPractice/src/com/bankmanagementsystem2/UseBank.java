package com.bankmanagementsystem2;

public class UseBank {

    public static void main(String[] args) {

        Customer c1 = new Customer("C101", "Ravi Kumar");

        SavingAccount sa = new SavingAccount("S-9001", 12000, c1, 6.5);
        CurrentAccount ca = new CurrentAccount("C-8001", 5000, c1, 3000);

        sa.displayAccount();
        sa.deposit(2000);
        sa.withdraw(5000);
        sa.applyInterest();

        System.out.println("----------------");

        ca.displayAccount();
        ca.withdraw(7000); 
        ca.withdraw(2000); 
    }
}
