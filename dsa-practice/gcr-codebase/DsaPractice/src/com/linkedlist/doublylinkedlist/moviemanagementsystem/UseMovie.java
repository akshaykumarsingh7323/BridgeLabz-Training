package com.linkedlist.doublylinkedlist.moviemanagementsystem;

public class UseMovie {
    public static void main(String[] args) {

        MovieDoublyLinkedList list = new MovieDoublyLinkedList();

        list.addAtBeginning(new Movie("Inception", "Nolan", 2010, 9.0));
        list.addAtEnd(new Movie("Interstellar", "Nolan", 2014, 8.8));
        list.addAtEnd(new Movie("Avatar", "Cameron", 2009, 8.5));
        list.addAtPosition(2, new Movie("Titanic", "Cameron", 1997, 8.7));

        list.displayForward();

        list.searchByDirector("Nolan");

        list.updateRating("Avatar", 9.1);

        list.removeByTitle("Titanic");

        System.out.println();
        list.displayForward();
        list.displayReverse();
    }
}
