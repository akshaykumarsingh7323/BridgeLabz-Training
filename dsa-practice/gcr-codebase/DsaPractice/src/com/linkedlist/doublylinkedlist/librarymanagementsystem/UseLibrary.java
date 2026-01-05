package com.linkedlist.doublylinkedlist.librarymanagementsystem;

public class UseLibrary {
    public static void main(String[] args) {

        Library library = new Library();

        library.addAtEnd(new Book(1, "Java Basics", "James Gosling", "Programming", true));
        library.addAtEnd(new Book(2, "Clean Code", "Robert Martin", "Software", true));
        library.addAtBeginning(new Book(3, "Data Structures", "Mark Allen", "CS", false));
        library.addAtPosition(2, new Book(4, "Algorithms", "CLRS", "CS", true));

        System.out.println("Library Books (Forward):");
        library.displayForward();

        System.out.println("\nLibrary Books (Reverse):");
        library.displayReverse();

        library.updateAvailability(2, false);

        System.out.println("\nAfter Updating Availability:");
        library.displayForward();

        library.removeByBookId(3);

        System.out.println("\nAfter Removing Book ID 3:");
        library.displayForward();

        System.out.println("\nTotal Books in Library: " + library.countBooks());
    }
}
