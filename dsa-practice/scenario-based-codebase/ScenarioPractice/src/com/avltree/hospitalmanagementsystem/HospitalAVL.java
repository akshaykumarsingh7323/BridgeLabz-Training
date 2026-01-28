package com.avltree.hospitalmanagementsystem;

public class HospitalAVL {

    private Patient root;

    private int height(Patient node) {
        return node == null ? 0 : node.height;
    }

    private int getBalance(Patient node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private Patient rightRotate(Patient y) {
        Patient x = y.left;
        Patient T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private Patient leftRotate(Patient x) {
        Patient y = x.right;
        Patient T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public void registerPatient(int time, String name) {
        root = insert(root, time, name);
    }

    private Patient insert(Patient node, int time, String name) {

        if (node == null)
            return new Patient(time, name);

        if (time < node.checkInTime)
            node.left = insert(node.left, time, name);
        else if (time > node.checkInTime)
            node.right = insert(node.right, time, name);
        else
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        if (balance > 1 && time < node.left.checkInTime)
            return rightRotate(node);

        if (balance < -1 && time > node.right.checkInTime)
            return leftRotate(node);

        if (balance > 1 && time > node.left.checkInTime) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && time < node.right.checkInTime) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public void dischargePatient(int time) {
        root = delete(root, time);
    }

    private Patient delete(Patient root, int time) {

        if (root == null)
            return root;

        if (time < root.checkInTime)
            root.left = delete(root.left, time);
        else if (time > root.checkInTime)
            root.right = delete(root.right, time);
        else {

            if (root.left == null || root.right == null) {
                root = (root.left != null) ? root.left : root.right;
            } else {
                Patient successor = minValue(root.right);
                root.checkInTime = successor.checkInTime;
                root.name = successor.name;
                root.right = delete(root.right, successor.checkInTime);
            }
        }

        if (root == null)
            return root;

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        int balance = getBalance(root);

        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    private Patient minValue(Patient node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    public void displayQueue() {
        inorder(root);
    }

    private void inorder(Patient node) {
        if (node != null) {
            inorder(node.left);
            System.out.println(formatTime(node.checkInTime)
                    + " - " + node.name);
            inorder(node.right);
        }
    }

    private String formatTime(int time) {
        int h = time / 100;
        int m = time % 100;
        return String.format("%02d:%02d", h, m);
    }
}

