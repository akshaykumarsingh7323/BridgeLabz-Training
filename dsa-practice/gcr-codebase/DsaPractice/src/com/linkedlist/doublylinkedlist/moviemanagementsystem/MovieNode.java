package com.linkedlist.doublylinkedlist.moviemanagementsystem;

public class MovieNode {
    Movie movie;
    MovieNode next;
    MovieNode prev;

    public MovieNode(Movie movie) {
        this.movie = movie;
        this.next = null;
        this.prev = null;
    }
}
