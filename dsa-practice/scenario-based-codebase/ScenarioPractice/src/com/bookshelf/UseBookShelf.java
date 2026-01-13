package com.bookshelf;

public class UseBookShelf {
    public static void main(String[] args) {

        BookShelf shelf = new BookShelf();

        shelf.addBook("Fiction", "1984", "George Orwell");
        shelf.addBook("Fiction", "Animal Farm", "George Orwell");
        shelf.addBook("Science", "Brief History of Time", "Stephen Hawking");

        shelf.displayCatalog();

        shelf.borrowBook("Fiction", "1984");

        shelf.displayCatalog();
    }
}

