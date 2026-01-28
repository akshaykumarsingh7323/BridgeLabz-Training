package com.avltree.onlineticketbooking;

public class EventBST {

    private Event root;

    public void insert(int startTime, String name) {
        root = insertRec(root, startTime, name);
    }

    private Event insertRec(Event root, int startTime, String name) {
        if (root == null)
            return new Event(startTime, name);

        if (startTime < root.startTime)
            root.left = insertRec(root.left, startTime, name);
        else if (startTime > root.startTime)
            root.right = insertRec(root.right, startTime, name);

        return root;
    }

    public void delete(int startTime) {
        root = deleteRec(root, startTime);
    }

    private Event deleteRec(Event root, int startTime) {
        if (root == null)
            return root;

        if (startTime < root.startTime)
            root.left = deleteRec(root.left, startTime);
        else if (startTime > root.startTime)
            root.right = deleteRec(root.right, startTime);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            Event successor = minValue(root.right);
            root.startTime = successor.startTime;
            root.eventName = successor.eventName;
            root.right = deleteRec(root.right, successor.startTime);
        }
        return root;
    }

    private Event minValue(Event node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    public void showUpcomingEvents() {
        inorderRec(root);
    }

    private void inorderRec(Event root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(formatTime(root.startTime)
                    + " - " + root.eventName);
            inorderRec(root.right);
        }
    }

    private String formatTime(int time) {
        int hour = time / 100;
        int min = time % 100;
        return String.format("%02d:%02d", hour, min);
    }
}
