package com.staticandfinal.level1;

public class UseBook {

	 public static void main(String[] args) {
		 System.out.println("\n-----  Library Management System -----\n");

		 Book.setLibraryName("Egmore Library");
		 
	       Book.displayLibraryName();

	       Book book1 = new Book("Effective Java", "Joshua Bloch", "978-0134685991");

	       book1.displayBookDetails();
	   }


}
