package com.multithreading.printshopscheduler;

public class PrintShopScheduler {

    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();

        System.out.println("Starting print jobs...\n");

        Thread job1 = new Thread(
                new PrintJob("Job1", 10, "Medium Priority"), "Job1-Thread");
        Thread job2 = new Thread(
                new PrintJob("Job2", 5, "High Priority"), "Job2-Thread");
        Thread job3 = new Thread(
                new PrintJob("Job3", 15, "Low Priority"), "Job3-Thread");
        Thread job4 = new Thread(
                new PrintJob("Job4", 8, "Medium Priority"), "Job4-Thread");
        Thread job5 = new Thread(
                new PrintJob("Job5", 12, "High Priority"), "Job5-Thread");

        job1.setPriority(5);  
        job2.setPriority(8);  
        job3.setPriority(3); 
        job4.setPriority(6);  
        job5.setPriority(7); 

        job1.start();
        job2.start();
        job3.start();
        job4.start();
        job5.start();

        job1.join();
        job2.join();
        job3.join();
        job4.join();
        job5.join();

        long endTime = System.currentTimeMillis();

        System.out.println("\nAll jobs completed in "
                + (endTime - startTime) + " ms");
    }
}
