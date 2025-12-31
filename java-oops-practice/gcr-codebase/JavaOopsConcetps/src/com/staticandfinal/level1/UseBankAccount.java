package com.staticandfinal.level1;

public class UseBankAccount {

	 public static void main(String[] args) {
		  System.out.println("\n----- Bank Account System -----\n");

	       BankAccount account1 = new BankAccount("Akshay Kumar Singh", "SBI7323", 1000.00);
	       BankAccount account2 = new BankAccount("Prince Singh", "ACC67890", 500.00);
	  
	       System.out.println("\nAccount 1 Details:\n");
	       account1.displayAccountDetails();
	       System.out.println("\nAccount 2 Details:\n");
	       account2.displayAccountDetails();

	       BankAccount.getTotalAccounts();
	     
	       System.out.println("\nPerforming transactions on Account 1:");
	       account1.deposit(200);
	       account1.withdraw(150);
	       account1.displayAccountDetails();
	       account2.displayAccountDetails();
	       account2.deposit(100);
	       account2.withdraw(800);
	   }


}
