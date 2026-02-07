package com.designpattern.librarymanagementsystem;

class Student extends User {

    public Student(String name) {
        super(name);
    }

    @Override
    public void update(Book book) {
        System.out.println("Student " + name + " notified about new book: " + book.getTitle());
    }
}

class Faculty extends User {

    public Faculty(String name) {
        super(name);
    }

    @Override
    public void update(Book book) {
        System.out.println("Faculty " + name + " notified about new book: " + book.getTitle());
    }
}

class Librarian extends User {

    public Librarian(String name) {
        super(name);
    }

    @Override
    public void update(Book book) {
        System.out.println("Librarian " + name + " notified about new book: " + book.getTitle());
    }
}
