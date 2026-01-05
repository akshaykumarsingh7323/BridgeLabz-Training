package com.linkedlist.circularlinkedlist.roundrobinschedulingalgorithm;

public class UseRoundRobin {
    public static void main(String[] args) {

        RoundRobinScheduler scheduler = new RoundRobinScheduler(4);

        scheduler.addProcess(new Process(1, 10, 1));
        scheduler.addProcess(new Process(2, 5, 2));
        scheduler.addProcess(new Process(3, 8, 1));

        scheduler.execute();
    }
}

