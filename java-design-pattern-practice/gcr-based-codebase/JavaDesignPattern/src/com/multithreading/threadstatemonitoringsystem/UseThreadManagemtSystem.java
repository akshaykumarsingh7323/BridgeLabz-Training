package com.multithreading.threadstatemonitoringsystem;

import java.util.Arrays;
import java.util.List;

public class UseThreadManagemtSystem {

    public static void main(String[] args) throws InterruptedException {

        TaskRunner t1 = new TaskRunner("Task-1");
        TaskRunner t2 = new TaskRunner("Task-2");

        List<Thread> tasks = Arrays.asList(t1, t2);

        StateMonitor monitor = new StateMonitor(tasks);

        monitor.start();

        Thread.sleep(500);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        monitor.join();
    }
}
