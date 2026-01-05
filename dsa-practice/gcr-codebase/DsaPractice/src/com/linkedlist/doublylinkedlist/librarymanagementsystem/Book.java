package com.linkedlist.doublylinkedlist.librarymanagementsystem;

class Book {
    int bookId;
    String title;
    String author;
    String genre;
    boolean isAvailable;

    Book next;
    Book prev;

    public Book(int bookId, String title, String author, String genre, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}
