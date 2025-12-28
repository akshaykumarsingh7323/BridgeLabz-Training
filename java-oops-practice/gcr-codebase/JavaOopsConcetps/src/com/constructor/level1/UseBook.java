package com.constructor.level1;

public class UseBook {

	public static void main(String[] args) {
		Book book1 = new Book();
		book1.display();
		System.out.println("=========================");
		Book book2 = new Book("Java Programming", "James Gosling", 499.99);
		book2.display();
	}

}
