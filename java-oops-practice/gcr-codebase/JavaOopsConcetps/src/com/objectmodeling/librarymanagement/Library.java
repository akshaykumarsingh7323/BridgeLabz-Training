package com.objectmodeling.librarymanagement;

import java.util.*;


class Library {
    private String name;
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (book != null) {
            books.add(book);
            System.out.println("Added \"" + book.getTitle() + "\" to " + this.name);
        }
    }

    public void displayBooks() {
        System.out.println("\n--- Books available at " + this.name + " ---");
        if (books.isEmpty()) {
            System.out.println("The library is currently empty.");
        } else {
            for (Book book : books) {
                System.out.println("- " + book.toString());
            }
        }
        System.out.println("----------------------------------------");
    }
}
