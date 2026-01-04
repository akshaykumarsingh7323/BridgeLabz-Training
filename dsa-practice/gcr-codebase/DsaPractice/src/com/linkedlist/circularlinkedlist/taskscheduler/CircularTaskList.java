package com.linkedlist.circularlinkedlist.taskscheduler;

public class CircularTaskList {

    private TaskNode head;
    private TaskNode current; // for task scheduling

    public void addAtBeginning(Task task) {
        TaskNode newNode = new TaskNode(task);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
            return;
        }

        TaskNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        newNode.next = head;
        temp.next = newNode;
        head = newNode;
    }

    public void addAtEnd(Task task) {
        TaskNode newNode = new TaskNode(task);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
            return;
        }

        TaskNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;
    }

    // 3. Add at Specific Position (1-based)
    public void addAtPosition(int position, Task task) {
        if (position <= 0) {
            System.out.println("Invalid position");
            return;
        }

        if (position == 1) {
            addAtBeginning(task);
            return;
        }

        TaskNode newNode = new TaskNode(task);
        TaskNode temp = head;

        for (int i = 1; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void removeByTaskId(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty");
            return;
        }

        TaskNode temp = head;
        TaskNode prev = null;

        do {
            if (temp.task.taskId == taskId) {

                if (temp == head && temp.next == head) {
                    head = current = null;
                    System.out.println("Task removed");
                    return;
                }

                // Head node removal
                if (temp == head) {
                    TaskNode last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                    current = head;
                } 
                else {
                    prev.next = temp.next;
                }

                System.out.println("Task removed");
                return;
            }

            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Task not found");
    }

    public void viewNextTask() {
        if (current == null) {
            System.out.println("No tasks available");
            return;
        }

        Task t = current.task;
        System.out.println("Current Task: " + t.taskId + " | " + t.taskName +
                " | Priority: " + t.priority + " | Due: " + t.dueDate);

        current = current.next;
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No tasks available");
            return;
        }

        TaskNode temp = head;
        System.out.println("All Tasks:");

        do {
            Task t = temp.task;
            System.out.println(t.taskId + " | " + t.taskName +
                    " | Priority: " + t.priority + " | Due: " + t.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // 7. Search by Priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available");
            return;
        }

        TaskNode temp = head;
        boolean found = false;

        do {
            if (temp.task.priority == priority) {
                Task t = temp.task;
                System.out.println(t.taskId + " | " + t.taskName +
                        " | Priority: " + t.priority + " | Due: " + t.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No task found with priority " + priority);
    }
}
