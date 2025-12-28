package com.constructor.level1;

//Create a Book class with attributes title, author, and price. Provide both default and parameterized constructors.

public class Book {

	private String title;
	private String author;
	private double price;
	
	Book(){
		this.title = "unknown";
		this.author = "unknown";
		this.price = 1000;
	}
	
	Book(String title, String author, double price){
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	public void display() {
		System.out.println("Title: " + title);
		System.out.println("Author: " + author);
		System.out.println("Price: " + price);
	}

}
