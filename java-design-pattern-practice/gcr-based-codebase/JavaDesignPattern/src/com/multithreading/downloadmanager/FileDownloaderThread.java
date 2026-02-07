package com.multithreading.downloadmanager;

import java.util.Random;

public class FileDownloaderThread extends Thread {

    private String fileName;
    private Random random = new Random();

    public FileDownloaderThread(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {

        for (int progress = 0; progress <= 100; progress += 10) {
            System.out.println("[" + Thread.currentThread().getName() +
                    "] Downloading " + fileName + ": " + progress + "%");

            try {
                Thread.sleep(random.nextInt(500) + 200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
