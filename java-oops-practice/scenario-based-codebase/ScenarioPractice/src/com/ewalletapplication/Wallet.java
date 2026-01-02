package com.ewalletapplication;

public abstract class Wallet implements Transferrable {

    private double balance;            
    protected User owner;                
    public Wallet(User owner, double initialAmount, boolean referralBonus) {
        this.owner = owner;
        this.balance = initialAmount;

        if (referralBonus) {
            this.balance += 100;        // referral credit
        }
    }

    public double getBalance() {
        return balance;
    }

    protected void loadMoney(double amount) {
        balance += amount;
    }

    protected boolean deduct(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public abstract void displayWalletInfo();
}
