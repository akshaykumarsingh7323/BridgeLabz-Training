package com.objectmodeling.librarymanagement;

public class UseLibrary {
    public static void main(String[] args) {

        Book b1 = new Book("Java Concept", "James Goasling");
        Book b2 = new Book("C++", "Bjarne Stroustrup");
        Book b3 = new Book("C language", "Dennis Ritchie");
        Book b4 = new Book("Python", "Guido Van Rossum");


        Library cityLibrary = new Library("City Public Library");
        Library universityLibrary = new Library("University Research Library");

        cityLibrary.addBook(b1);
        cityLibrary.addBook(b2);
        cityLibrary.addBook(b4);

        universityLibrary.addBook(b2);
        universityLibrary.addBook(b3);

        cityLibrary.displayBooks();
        universityLibrary.displayBooks();

        
        System.out.println("\nIf City Public Library closes, Book b1 still exists: " + b1.toString());
    }
}
