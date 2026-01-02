package com.bankmanagementsystem2;

public class CurrentAccount extends Account {

    private double overdraftLimit;

    public CurrentAccount(String accNo, double balance, Customer c, double overdraftLimit) {
        super(accNo, balance, c);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (BankHelper.checkOverdraftEligibility(balance, overdraftLimit, amount)) {
            balance -= amount;
            System.out.println("Withdrawal successful (Overdraft Considered). Balance: " + balance);
        }
    }
}
