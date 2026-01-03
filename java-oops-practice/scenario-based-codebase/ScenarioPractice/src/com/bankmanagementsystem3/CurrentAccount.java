package com.bankmanagementsystem3;

class CurrentAccount extends Account {

    private static final double INTEREST_RATE = 1.0; 

    public CurrentAccount(String accNo) {
        super(accNo);
    }

    @Override
    public void calculateInterest() {
        double interest = checkBalance() * INTEREST_RATE / 100;
        addInterest(interest);
        System.out.println("Current Interest Added: " + interest);
    }
}
