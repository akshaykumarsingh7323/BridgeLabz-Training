package com.linkedlist.doublylinkedlist.moviemanagementsystem;

public class MovieDoublyLinkedList {

    private MovieNode head;
    private MovieNode tail;

    public void addAtBeginning(Movie movie) {
        MovieNode newNode = new MovieNode(movie);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void addAtEnd(Movie movie) {
        MovieNode newNode = new MovieNode(movie);

        if (tail == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void addAtPosition(int position, Movie movie) {
        if (position <= 0) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 1) {
            addAtBeginning(movie);
            return;
        }

        MovieNode temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(movie);
            return;
        }

        MovieNode newNode = new MovieNode(movie);
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    public void removeByTitle(String title) {
        MovieNode temp = head;

        while (temp != null) {
            if (temp.movie.title.equalsIgnoreCase(title)) {

                if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } 
                else if (temp == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } 
                else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }

                System.out.println("Movie removed successfully");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found");
    }

    public void searchByDirector(String director) {
        MovieNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.movie.director.equalsIgnoreCase(director)) {
                printMovie(temp.movie);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No movies found for this director");
    }

    public void searchByRating(double rating) {
        MovieNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.movie.rating == rating) {
                printMovie(temp.movie);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No movies found with this rating");
    }

    // 7. Update Rating by Movie Title
    public void updateRating(String title, double newRating) {
        MovieNode temp = head;

        while (temp != null) {
            if (temp.movie.title.equalsIgnoreCase(title)) {
                temp.movie.rating = newRating;
                System.out.println("Rating updated successfully");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found");
    }

    public void displayForward() {
        MovieNode temp = head;
        System.out.println("Movies (Forward):");

        while (temp != null) {
            printMovie(temp.movie);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        MovieNode temp = tail;
        System.out.println("Movies (Reverse):");

        while (temp != null) {
            printMovie(temp.movie);
            temp = temp.prev;
        }
    }

    private void printMovie(Movie m) {
        System.out.println(m.title + " | " + m.director + " | " + m.year + " | Rating: " + m.rating);
    }
}
