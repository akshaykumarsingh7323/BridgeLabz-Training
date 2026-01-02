package com.ewalletapplication;

public class PersonalWallet extends Wallet {

    private static final double DAILY_LIMIT = 5000;
    public PersonalWallet(User owner, double initialAmount, boolean referralBonus) {
        super(owner, initialAmount, referralBonus);
    }

    @Override
    public boolean transferTo(User receiver, double amount) {

        if (amount > DAILY_LIMIT) {
            System.out.println("Transfer failed: exceeds personal wallet daily limit.");
            return false;
        }

        if (deduct(amount)) {
            System.out.println("Personal Wallet Transfer: "
                    + amount + " sent to " + receiver.getName());
            return true;
        }

        System.out.println("Transfer failed: insufficient balance.");
        return false;
    }

    @Override
    public void displayWalletInfo() {
        System.out.println("Personal Wallet | User: " + owner.getName()
                + " | Balance: " + getBalance());
    }
}
