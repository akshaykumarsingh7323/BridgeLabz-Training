package com.inheritence.bankaccount;

class FixedDepositAccount extends BankAccount {
    int durationInMonths;

    FixedDepositAccount(String accountNumber, double balance, int durationInMonths) {
        super(accountNumber, balance);
        this.durationInMonths = durationInMonths;
    }

    @Override
    void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
        System.out.println("Duration: " + durationInMonths + " months");
    }
}
