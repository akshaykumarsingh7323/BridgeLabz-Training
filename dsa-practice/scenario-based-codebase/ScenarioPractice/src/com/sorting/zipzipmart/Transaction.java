package com.sorting.zipzipmart;

public class Transaction {
	String date;
	double amount;
	
	public Transaction(String date, double amount) {
		this.date = date;
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return date + " Rs " + amount;
	}
}
