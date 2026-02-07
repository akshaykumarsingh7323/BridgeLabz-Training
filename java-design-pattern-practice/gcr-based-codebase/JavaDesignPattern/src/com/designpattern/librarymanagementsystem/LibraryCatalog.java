package com.designpattern.librarymanagementsystem;

import java.util.*;

class LibraryCatalog {

    private static LibraryCatalog instance;
    private List<Book> books = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    private LibraryCatalog() {
    }

    public static synchronized LibraryCatalog getInstance() {
        if (instance == null) {
            instance = new LibraryCatalog();
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
        notifyObservers(book);
    }

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers(Book book) {
        for (Observer o : observers) {
            o.update(book);
        }
    }
}

