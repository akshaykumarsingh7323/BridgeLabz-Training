package com.constructor.level1;

public class UseLibraryBook {
	public static void main(String[] args) {
		LibraryBook b1 = new LibraryBook("Java Basics", "James Gosling", 499.0);
        b1.display();
        b1.borrowBook();
        b1.display();
        b1.borrowBook();
    }
}

