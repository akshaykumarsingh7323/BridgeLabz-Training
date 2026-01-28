package com.avltree.gamingapp;

public class AVLLeaderBoard {

    private Player root;

    private int height(Player node) {
        return node == null ? 0 : node.height;
    }

    private int getBalance(Player node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private Player rightRotate(Player y) {
        Player x = y.left;
        Player T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private Player leftRotate(Player x) {
        Player y = x.right;
        Player T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public void insertOrUpdate(int playerId, int score) {
        root = insert(root, playerId, score);
    }

    private Player insert(Player node, int playerId, int score) {

        if (node == null)
            return new Player(playerId, score);

        if (score > node.score)
            node.left = insert(node.left, playerId, score);
        else if (score < node.score)
            node.right = insert(node.right, playerId, score);
        else
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && score > node.left.score)
            return rightRotate(node);

        if (balance < -1 && score < node.right.score)
            return leftRotate(node);

        if (balance > 1 && score < node.left.score) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && score > node.right.score) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public void removePlayer(int score) {
        root = delete(root, score);
    }

    private Player delete(Player root, int score) {

        if (root == null)
            return root;

        if (score > root.score)
            root.left = delete(root.left, score);
        else if (score < root.score)
            root.right = delete(root.right, score);
        else {

            if ((root.left == null) || (root.right == null)) {
                Player temp = root.left != null ? root.left : root.right;
                root = temp;
            } else {
                Player temp = minValueNode(root.right);
                root.score = temp.score;
                root.right = delete(root.right, temp.score);
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

    private Player minValueNode(Player node) {
        Player current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    public void showTopPlayers() {
        System.out.println("Top Players:");
        reverseInorder(root, 10);
    }

    private int count = 0;

    private void reverseInorder(Player node, int limit) {
        if (node != null && count < limit) {
            reverseInorder(node.left, limit);
            if (count < limit) {
                System.out.println("Player ID: " + node.playerId + " | Score: " + node.score);
                count++;
            }
            reverseInorder(node.right, limit);
        }
    }
}
