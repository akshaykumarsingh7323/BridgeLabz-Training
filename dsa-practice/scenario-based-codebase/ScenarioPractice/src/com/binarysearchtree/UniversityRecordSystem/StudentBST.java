package com.binarysearchtree.UniversityRecordSystem;

public class StudentBST {
    private TreeNode root;

    public void insert(Student student) {
        root = insertRec(root, student);
    }

    private TreeNode insertRec(TreeNode root, Student student) {
        if (root == null) {
            return new TreeNode(student);
        }

        if (student.getRollNo() < root.student.getRollNo()) {
            root.left = insertRec(root.left, student);
        } else if (student.getRollNo() > root.student.getRollNo()) {
            root.right = insertRec(root.right, student);
        }

        return root;
    }

    public void delete(int rollNo) {
        root = deleteRec(root, rollNo);
    }

    private TreeNode deleteRec(TreeNode root, int rollNo) {
        if (root == null) return null;

        if (rollNo < root.student.getRollNo()) {
            root.left = deleteRec(root.left, rollNo);
        } else if (rollNo > root.student.getRollNo()) {
            root.right = deleteRec(root.right, rollNo);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            TreeNode successor = findMin(root.right);
            root.student = successor.student;
            root.right = deleteRec(root.right, successor.student.getRollNo());
        }
        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public Student search(int rollNo) {
        return searchRec(root, rollNo);
    }

    private Student searchRec(TreeNode root, int rollNo) {
        if (root == null) return null;

        if (rollNo == root.student.getRollNo()) {
            return root.student;
        }

        if (rollNo < root.student.getRollNo()) {
            return searchRec(root.left, rollNo);
        }
        return searchRec(root.right, rollNo);
    }

    public void displaySorted() {
        System.out.println("Students (Sorted by Roll Number):\n");
        inorder(root);
    }

    private void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.println("Roll No: " +
                    root.student.getRollNo() +
                    ", Name: " +
                    root.student.getName());
            inorder(root.right);
        }
    }
}