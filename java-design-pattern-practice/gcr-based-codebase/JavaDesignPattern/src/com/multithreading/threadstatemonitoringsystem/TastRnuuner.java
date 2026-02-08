package com.multithreading.threadstatemonitoringsystem;

class TaskRunner extends Thread {

    public TaskRunner(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            // RUNNABLE (computation)
            for (int i = 0; i < 1_000_000; i++) {
                Math.sqrt(i);
            }

            // TIMED_WAITING
            Thread.sleep(2000);

            // RUNNABLE again
            for (int i = 0; i < 1_000_000; i++) {
                Math.pow(i, 2);
            }

        } catch (InterruptedException e) {
            System.out.println(getName() + " interrupted");
        }
        // TERMINATED after run() ends
    }
}
