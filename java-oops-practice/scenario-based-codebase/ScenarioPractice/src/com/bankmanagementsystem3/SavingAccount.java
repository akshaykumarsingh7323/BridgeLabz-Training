package com.bankmanagementsystem3;

class SavingsAccount extends Account {

    private static final double INTEREST_RATE = 4.0; 

    public SavingsAccount(String accNo, double openingBalance) {
        super(accNo, openingBalance);
    }

    @Override
    public void calculateInterest() {
        double interest = checkBalance() * INTEREST_RATE / 100;
        addInterest(interest);
        System.out.println("Savings Interest Added: " + interest);
    }
}
