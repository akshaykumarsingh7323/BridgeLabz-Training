package com.ewalletapplication;

public class BusinessWallet extends Wallet {

    private static final double TAX_RATE = 0.02; 
    public BusinessWallet(User owner, double initialAmount, boolean referralBonus) {
        super(owner, initialAmount, referralBonus);
    }

    @Override
    public boolean transferTo(User receiver, double amount) {

        double tax = amount * TAX_RATE;
        double total = amount + tax;

        if (deduct(total)) {
            System.out.println("Business Wallet Transfer: "
                    + amount + " sent to " + receiver.getName()
                    + " | Tax charged: " + tax);
            return true;
        }

        System.out.println("Business transfer failed: insufficient balance.");
        return false;
    }

    @Override
    public void displayWalletInfo() {
        System.out.println("Business Wallet | User: " + owner.getName()
                + " | Balance: " + getBalance());
    }
}
