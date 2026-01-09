package com.inputstreamreader;

import java.io.*;

public class ConvertByteStreamToCharacterStream {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("input.txt");

            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");

            BufferedReader br = new BufferedReader(isr);

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
            isr.close();
            fis.close();

        } catch (UnsupportedEncodingException e) {
            System.out.println("Unsupported encoding!");
        } catch (IOException e) {
            System.out.println("File reading error!");
        }
    }
}

