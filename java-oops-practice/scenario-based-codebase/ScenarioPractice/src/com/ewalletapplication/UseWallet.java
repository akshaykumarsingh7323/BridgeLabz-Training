package com.ewalletapplication;

public class UseWallet {
    public static void main(String[] args) {

        User u1 = new User("Amit", "U101");
        User u2 = new User("Riya", "U202");

        Wallet w1 = new PersonalWallet(u1, 2000, true);
        Wallet w2 = new BusinessWallet(u2, 5000, false);

        w1.displayWalletInfo();
        w2.displayWalletInfo();

        boolean success = w1.transferTo(u2, 1500);

        if (success) {
            Transaction t = new Transaction(u1, u2, 1500);
            t.printTransaction();
        }

        w1.displayWalletInfo();
        w2.displayWalletInfo();
    }
}
