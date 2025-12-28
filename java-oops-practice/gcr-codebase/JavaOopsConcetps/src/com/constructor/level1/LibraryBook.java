package com.constructor.level1;

public class LibraryBook {
	String title;
	String author;
	double price;
	boolean available;
	
	LibraryBook(String title, String author, double price){
		this.title = title;
		this.author = author;
		this.price = price;
		this.available = true;
	}
	
	void borrowBook() {
		if(available) {
			available = false;
			System.out.println("Book borrowed successfully!");
		}else {
			System.out.println("Sorry, the book is already borrowed.");
		}
	}
	
	void display() {
		System.out.println("Title: " + title + ", Author: " + author + ", Price: Rs " + price + ", Available: " + available );
	}
}
