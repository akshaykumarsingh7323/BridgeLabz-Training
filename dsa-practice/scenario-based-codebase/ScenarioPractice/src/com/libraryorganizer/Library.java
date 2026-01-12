package com.libraryorganizer;

import java.util.*;

class Library {
    private HashMap<String, LinkedList<Book>> catalog = new HashMap<>();
    private HashSet<String> isbnSet = new HashSet<>();

    public void addBook(String genre, Book book) {
        if (isbnSet.contains(book.isbn)) {
            System.out.println("Duplicate book not allowed!");
            return;
        }

        catalog.putIfAbsent(genre, new LinkedList<>());
        catalog.get(genre).add(book);
        isbnSet.add(book.isbn);

        System.out.println("Book added: " + book);
    }

    public void borrowBook(String genre, String isbn) {
        LinkedList<Book> books = catalog.get(genre);
        if (books == null) {
            System.out.println("Genre not found!");
            return;
        }

        Iterator<Book> it = books.iterator();
        while (it.hasNext()) {
            Book b = it.next();
            if (b.isbn.equals(isbn)) {
                it.remove();
                isbnSet.remove(isbn);
                System.out.println("Book borrowed: " + b);
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public void displayCatalog() {
        for (String genre : catalog.keySet()) {
            System.out.println("\nGenre: " + genre);
            for (Book book : catalog.get(genre)) {
                System.out.println("  " + book);
            }
        }
    }
}
