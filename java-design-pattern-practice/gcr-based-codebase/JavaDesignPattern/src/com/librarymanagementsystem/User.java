package com.librarymanagementsystem;

abstract class User implements Observer {

    protected String name;

    public User(String name) {
        this.name = name;
    }

    public abstract void update(Book book);
}

