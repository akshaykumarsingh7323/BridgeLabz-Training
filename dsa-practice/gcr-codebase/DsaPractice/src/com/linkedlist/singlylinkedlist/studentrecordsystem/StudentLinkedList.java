package com.linkedlist.singlylinkedlist.studentrecordsystem;

public class StudentLinkedList {

    private StudentNode head;

    public void addAtBeginning(Student student) {
        StudentNode newNode = new StudentNode(student);
        newNode.next = head;
        head = newNode;
    }

    public void addAtEnd(Student student) {
        StudentNode newNode = new StudentNode(student);

        if (head == null) {
            head = newNode;
            return;
        }

        StudentNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void addAtPosition(int position, Student student) {
        if (position <= 0) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 1) {
            addAtBeginning(student);
            return;
        }

        StudentNode newNode = new StudentNode(student);
        StudentNode temp = head;

        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of range");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void deleteByRollNo(int rollNo) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.student.rollNo == rollNo) {
            head = head.next;
            System.out.println("Student deleted");
            return;
        }

        StudentNode temp = head;
        while (temp.next != null && temp.next.student.rollNo != rollNo) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student not found");
        } else {
            temp.next = temp.next.next;
            System.out.println("Student deleted");
        }
    }

    public void search(int rollNo) {
        StudentNode temp = head;

        while (temp != null) {
            if (temp.student.rollNo == rollNo) {
                Student s = temp.student;
                System.out.println("Found: " + s.rollNo + " " + s.name + " " + s.age + " " + s.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }

    public void updateGrade(int rollNo, char newGrade) {
        StudentNode temp = head;

        while (temp != null) {
            if (temp.student.rollNo == rollNo) {
                temp.student.grade = newGrade;
                System.out.println("Grade updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }

    public void display() {
        if (head == null) {
            System.out.println("No records available");
            return;
        }

        StudentNode temp = head;
        System.out.println("RollNo Name Age Grade");
        while (temp != null) {
            Student s = temp.student;
            System.out.println(s.rollNo + " " + s.name + " " + s.age + " " + s.grade);
            temp = temp.next;
        }
    }
}
