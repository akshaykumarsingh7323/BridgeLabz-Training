package com.constructor.level1;

public class UseBankAccount {
	public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount(
            "SB12345", "Akshay", 10000, 4.5
        );

        sa.displaySavingsDetails();

        sa.deposit(2000);
        sa.withdraw(1500);

        System.out.println("Updated Balance: Rs " + sa.getBalance());
    }
}
