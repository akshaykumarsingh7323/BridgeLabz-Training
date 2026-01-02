package com.inheritence.bankaccount;

public class UseBank {
    public static void main(String[] args) {

    	BankAccount sa = new SavingsAccount("SA101", 5000, 4.5);
        BankAccount ca = new CheckingAccount("CA202", 3000, 1000);
        BankAccount fda = new FixedDepositAccount("FD303", 10000, 12);

        BankAccount[] accounts = {sa, ca, fda};

        for (BankAccount account : accounts) {
            account.displayDetails();
            account.displayAccountType();
            System.out.println("---------------------------");
        }
    }
}
