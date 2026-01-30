package com.functionalinterface.functionalinterfaces.backgroundjobexecution;

public class BackgroundJobExecution {

    public static void main(String[] args) {

        Runnable backgroundTask = () -> {
            System.out.println("Background task started...");
            try {
                Thread.sleep(3000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Background task completed.");
        };

        Thread worker = new Thread(backgroundTask);
        worker.start();

        System.out.println("Main thread is free to do other work...");
    }
}

