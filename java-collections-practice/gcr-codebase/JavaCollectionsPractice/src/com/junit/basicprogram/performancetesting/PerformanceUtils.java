package com.junit.basicprogram.performancetesting;

public class PerformanceUtils {

    public String longRunningTask() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); 
        }
        return "Done";
    }
}
