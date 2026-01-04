package com.linkedlist.singlylinkedlist.studentrecordsystem;

public class UseStudent {
    public static void main(String[] args) {

        StudentLinkedList list = new StudentLinkedList();

        list.addAtBeginning(new Student(101, "Akshay", 20, 'A'));
        list.addAtEnd(new Student(102, "Rahul", 21, 'B'));
        list.addAtEnd(new Student(103, "Sneha", 19, 'A'));
        list.addAtPosition(2, new Student(104, "Neha", 22, 'C'));

        list.display();

        list.search(102);

        list.updateGrade(104, 'A');

        list.deleteByRollNo(101);

        System.out.println("\nAfter Updates:");
        list.display();
    }
}

