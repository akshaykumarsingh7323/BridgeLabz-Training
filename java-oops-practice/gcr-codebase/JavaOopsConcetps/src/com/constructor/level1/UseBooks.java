package com.constructor.level1;

public class UseBooks {
	public static void main(String[] args) {
        Books b1 = new Books("978-0134685991", "Effective Java", "Joshua Bloch");
        b1.displayBook();

        b1.setAuthor("J. Bloch");
        System.out.println("Updated Author: " + b1.getAuthor());

        EBook eb = new EBook(
            "978-1492078005",
            "Java Cookbook",
            "Ian F. Darwin",
            "PDF"
        );
        eb.displayEBookDetails();
    }
}

