package com.linkedlist.circularlinkedlist.taskscheduler;

public class UseTask {
    public static void main(String[] args) {

        CircularTaskList scheduler = new CircularTaskList();

        scheduler.addAtEnd(new Task(1, "Design Module", 1, "10-Jan"));
        scheduler.addAtEnd(new Task(2, "Write Code", 2, "12-Jan"));
        scheduler.addAtBeginning(new Task(3, "Testing", 1, "15-Jan"));
        scheduler.addAtPosition(2, new Task(4, "Documentation", 3, "18-Jan"));

        scheduler.displayAll();

        System.out.println("\nSearching Priority 1:");
        scheduler.searchByPriority(1);

        System.out.println("\nTask Scheduling:");
        scheduler.viewNextTask();
        scheduler.viewNextTask();
        scheduler.viewNextTask();

        scheduler.removeByTaskId(2);

        System.out.println("\nAfter Removal:");
        scheduler.displayAll();
    }
}
