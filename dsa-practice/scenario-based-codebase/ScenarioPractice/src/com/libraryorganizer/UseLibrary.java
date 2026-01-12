package com.libraryorganizer;

public class UseLibrary {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook("Fiction", new Book("1984", "George Orwell", "ISBN101"));
        library.addBook("Fiction", new Book("Animal Farm", "George Orwell", "ISBN102"));
        library.addBook("Science", new Book("Brief History of Time", "Stephen Hawking", "ISBN201"));

        library.borrowBook("Fiction", "ISBN101");

        library.displayCatalog();
    }
}
