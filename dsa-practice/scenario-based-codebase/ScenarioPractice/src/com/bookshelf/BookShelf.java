package com.bookshelf;

import java.util.*;

class BookShelf {

    private HashMap<String, LinkedList<Book>> catalog = new HashMap<>();

    private HashSet<String> bookSet = new HashSet<>();

    public void addBook(String genre, String title, String author) {

        String key = genre + title + author;
        if (bookSet.contains(key)) {
            System.out.println("Duplicate book not allowed");
            return;
        }

        catalog.putIfAbsent(genre, new LinkedList<>());
        catalog.get(genre).add(new Book(title, author));
        bookSet.add(key);

        System.out.println("Book added: " + title);
    }

    public void borrowBook(String genre, String title) {

        if (!catalog.containsKey(genre)) {
            System.out.println("Genre not found");
            return;
        }

        LinkedList<Book> books = catalog.get(genre);
        Iterator<Book> it = books.iterator();

        while (it.hasNext()) {
            Book b = it.next();
            if (b.title.equals(title)) {
                it.remove();
                bookSet.remove(genre + b.title + b.author);
                System.out.println("Book borrowed: " + title);
                return;
            }
        }

        System.out.println("Book not available");
    }

    public void displayCatalog() {

        if (catalog.isEmpty()) {
            System.out.println("Library empty");
            return;
        }

        for (String genre : catalog.keySet()) {
            System.out.println("Genre: " + genre);
            for (Book b : catalog.get(genre)) {
                System.out.println("  " + b);
            }
        }
    }
}
