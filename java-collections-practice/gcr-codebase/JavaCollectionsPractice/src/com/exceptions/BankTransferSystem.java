package com.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

class InsufficientBalanceException  extends Exception{
	InsufficientBalanceException(String message){
		super(message);
	}
}

class BankAccount {
	private double balance;
	BankAccount(double balance){
		this.balance = balance;
	}
	
	void withdraw(double amount) throws InsufficientBalanceException{
		if(amount < 0) {
			throw new IllegalArgumentException("Invalid amount!");
		}
		
		if(balance < amount) {
			throw new InsufficientBalanceException("Insufficient balance!");
		}
		
		balance -= amount;
        System.out.println("Withdrawal successful, new balance: " + balance);
	}
}

public class BankTransferSystem{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankAccount account =  new BankAccount(10000);
		
		try {
			
			System.out.println("Enter withdraw amount: ");
			int amount = sc.nextInt();
			account.withdraw(amount);
			
		}catch(InsufficientBalanceException e) {
			
			System.out.println(e.getMessage());
			
		}catch(IllegalArgumentException e) {
			
			System.out.println(e.getMessage());
			
		}catch(InputMismatchException e){
			
			System.out.println("Invalid input!");
			
		}
	}
}
