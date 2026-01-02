package com.encapsulation.bankingsystem;

class SavingsAccount extends BankAccount implements Loanable {
    private static final double INTEREST_RATE = 0.04; // 4%

    public SavingsAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * INTEREST_RATE;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Savings Account loan applied for ₹" + amount);
    }

    @Override
    public double calculateLoanEligibility() {
        return balance * 5; // eligible up to 5x balance
    }
}
