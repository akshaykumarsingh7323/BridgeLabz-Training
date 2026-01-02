package com.encapsulation.bankingsystem;

import java.util.*;

public class UseBank {
    public static void main(String[] args) {

        List<BankAccount> accounts = new ArrayList<>();

        accounts.add(new SavingsAccount("SA101", "Rohit", 50000));
        accounts.add(new CurrentAccount("CA202", "Anita", 100000));

        for (BankAccount acc : accounts) {
            System.out.println("Account Holder: " + acc.getHolderName());
            System.out.println("Account Number: " + acc.getAccountNumber());
            System.out.println("Balance: Rs " + acc.getBalance());

            double interest = acc.calculateInterest();
            System.out.println("Calculated Interest: ₹" + interest);

            if (acc instanceof Loanable) {
                Loanable loanAcc = (Loanable) acc;
                System.out.println("Loan Eligibility: ₹" +
                                   loanAcc.calculateLoanEligibility());
            }

            System.out.println("--------------------------------");
        }
    }
}
