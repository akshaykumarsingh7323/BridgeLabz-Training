package com.binarysearchtree.songmusicapp;

public class UseMusic {

    public static void main(String[] args) {

        MusicLibrary library = new MusicLibrary();

        library.insert(105, "Shape of You");
        library.insert(102, "Believer");
        library.insert(110, "Perfect");
        library.insert(101, "Alone");
        library.insert(108, "Faded");

        System.out.println("Searching Track ID 110:");
        Song song = library.search(110);
        if (song != null)
            System.out.println("Found: " + song.title);
        else
            System.out.println("Track not found");

        System.out.println("\nPlaylist (Alphabetical Order):");
        library.showPlaylist();
    }
}

