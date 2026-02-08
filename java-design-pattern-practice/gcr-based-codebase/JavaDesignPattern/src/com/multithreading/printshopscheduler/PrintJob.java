package com.multithreading.printshopscheduler;

class PrintJob implements Runnable {

    private String jobName;
    private int pages;
    private String priorityLabel;

    public PrintJob(String jobName, int pages, String priorityLabel) {
        this.jobName = jobName;
        this.pages = pages;
        this.priorityLabel = priorityLabel;
    }

    @Override
    public void run() {

        for (int i = 1; i <= pages; i++) {
            System.out.println("[" + priorityLabel + "] Printing "
                    + jobName + " - Page " + i + " of " + pages);

            try {
                Thread.sleep(100); // 100ms per page
            } catch (InterruptedException e) {
                System.out.println(jobName + " interrupted");
            }
        }

        System.out.println(jobName + " completed by "
                + Thread.currentThread().getName());
    }
}
