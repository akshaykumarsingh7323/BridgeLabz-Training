package com.inputstreamreader;

import java.io.*;

public class InputStreamReaderToFile {
    public static void main(String[] args) {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            FileWriter fw = new FileWriter("output.txt");

            String input;

            System.out.println("Enter text (type 'exit' to stop):");

            while (true) {
                input = br.readLine();

                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                fw.write(input + System.lineSeparator());
            }

            fw.close();
            br.close();
            isr.close();

            System.out.println("Input saved to file successfully.");

        } catch (IOException e) {
            System.out.println("Error occurred!");
        }
    }
}

