package com.javastream;

import java.io.*;

public class BufferedVsUnbufferedCopy {

    private static final int BUFFER_SIZE = 4096; 

    public static void main(String[] args) {

        String sourceFile = "largefile.dat";
        String destUnbuffered = "copy_unbuffered.dat";
        String destBuffered = "copy_buffered.dat";

        copyUsingUnbufferedStream(sourceFile, destUnbuffered);
        copyUsingBufferedStream(sourceFile, destBuffered);
    }

    // UNBUFFERED STREAM
    private static void copyUsingUnbufferedStream(String source, String dest) {

        long startTime = System.nanoTime();

        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            long endTime = System.nanoTime();
            System.out.println("Unbuffered Copy Time: "
                    + (endTime - startTime) / 1_000_000 + " ms");

        } catch (IOException e) {
            System.out.println("Error in unbuffered copy: " + e.getMessage());
        }
    }

    // BUFFERED STREAM 
    private static void copyUsingBufferedStream(String source, String dest) {

        long startTime = System.nanoTime();

        try (BufferedInputStream bis =
                     new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos =
                     new BufferedOutputStream(new FileOutputStream(dest))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

            long endTime = System.nanoTime();
            System.out.println("Buffered Copy Time: "
                    + (endTime - startTime) / 1_000_000 + " ms");

        } catch (IOException e) {
            System.out.println("Error in buffered copy: " + e.getMessage());
        }
    }
}
