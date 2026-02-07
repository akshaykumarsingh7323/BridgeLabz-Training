package com.librarymanagementsystem;

public class UseLibraryManagementSystem {

    public static void main(String[] args) {

        // Singleton
        LibraryCatalog catalog = LibraryCatalog.getInstance();

        // Factory
        User u1 = UserFactory.createUser("student", "Akshay");
        User u2 = UserFactory.createUser("faculty", "Dr. Sharma");
        User u3 = UserFactory.createUser("librarian", "Admin");

        // Observer subscription
        catalog.subscribe(u1);
        catalog.subscribe(u2);
        catalog.subscribe(u3);

        // Builder
        Book book1 = new Book.BookBuilder("Effective Java")
                .author("Joshua Bloch")
                .edition("3rd")
                .genre("Programming")
                .build();

        Book book2 = new Book.BookBuilder("Design Patterns")
                .author("GoF")
                .genre("Software Engineering")
                .build();

        // Add books
        catalog.addBook(book1);
        catalog.addBook(book2);
    }
}

