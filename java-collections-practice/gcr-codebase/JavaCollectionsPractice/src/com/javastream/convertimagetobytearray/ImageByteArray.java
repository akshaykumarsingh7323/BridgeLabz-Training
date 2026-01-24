package com.javastream.convertimagetobytearray;

import java.io.*;

public class ImageByteArray {

    public static void main(String[] args) {

        String sourceImage = "input.jpg";
        String targetImage = "output.jpg";

        try {
            byte[] imageBytes = imageToByteArray(sourceImage);
            byteArrayToImage(imageBytes, targetImage);

            System.out.println("Image converted successfully.");
        } 
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } 
        catch (IOException e) {
            System.out.println("I/O error occurred: " + e.getMessage());
        } 
        catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    private static byte[] imageToByteArray(String filePath)
            throws IOException {

        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;

        try {
            fis = new FileInputStream(filePath);
            baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();

        } finally {
            if (fis != null)
                fis.close();
            if (baos != null)
                baos.close();
        }
    }

    private static void byteArrayToImage(byte[] imageBytes, String filePath)
            throws IOException {

        ByteArrayInputStream bais = null;
        FileOutputStream fos = null;

        try {
            bais = new ByteArrayInputStream(imageBytes);
            fos = new FileOutputStream(filePath);

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } finally {
            if (bais != null)
                bais.close();
            if (fos != null)
                fos.close();
        }
    }
}
