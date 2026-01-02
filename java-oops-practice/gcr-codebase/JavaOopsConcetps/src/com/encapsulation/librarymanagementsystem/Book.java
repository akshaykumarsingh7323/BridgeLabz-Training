package com.encapsulation.librarymanagementsystem;

class Book extends LibraryItem implements Reservable {

    public Book(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; 
    }

    @Override
    public void reserveItem() {
        System.out.println("Book reserved successfully");
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}
