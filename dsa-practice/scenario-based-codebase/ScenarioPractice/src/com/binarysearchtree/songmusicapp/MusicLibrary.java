package com.binarysearchtree.songmusicapp;

public class MusicLibrary {

    Song root;

    public void insert(int trackId, String title) {
        root = insertRec(root, trackId, title);
    }

    private Song insertRec(Song root, int trackId, String title) {
        if (root == null) {
            return new Song(trackId, title);
        }

        if (trackId < root.trackId)
            root.left = insertRec(root.left, trackId, title);
        else if (trackId > root.trackId)
            root.right = insertRec(root.right, trackId, title);

        return root;
    }

    public Song search(int trackId) {
        return searchRec(root, trackId);
    }

    private Song searchRec(Song root, int trackId) {
        if (root == null || root.trackId == trackId)
            return root;

        if (trackId < root.trackId)
            return searchRec(root.left, trackId);

        return searchRec(root.right, trackId);
    }

    public void showPlaylist() {
        inorderRec(root);
    }

    private void inorderRec(Song root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.title + " (Track ID: " + root.trackId + ")");
            inorderRec(root.right);
        }
    }
}
