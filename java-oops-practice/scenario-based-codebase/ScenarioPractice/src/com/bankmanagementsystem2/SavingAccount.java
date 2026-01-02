package com.bankmanagementsystem2;

public class SavingAccount extends Account {

    private double interestRate;

    public SavingAccount(String accNo, double balance, Customer c, double interestRate) {
        super(accNo, balance, c);
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (BankHelper.canWithdraw(balance, amount)) {
            balance -= amount;
            System.out.println("Withdrawal successful. Balance: " + balance);
        }
    }

    public void applyInterest() {
        double interest = BankHelper.calculateInterest(balance, interestRate);
        balance += interest;
        System.out.println("Interest Added: " + interest + " | New Balance: " + balance);
    }
}
