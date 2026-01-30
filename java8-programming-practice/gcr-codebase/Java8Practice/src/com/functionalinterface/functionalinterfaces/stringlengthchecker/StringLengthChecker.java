package com.functionalinterface.functionalinterfaces.stringlengthchecker;

import java.util.function.Function;

public class StringLengthChecker {

    public static void main(String[] args) {

        int maxLimit = 20;

        Function<String, Integer> lengthFunction = (message) -> message.length();

        String[] messages = {"Hello", "Welcome to Java 8 programming", "Hi"};

        for (String msg : messages) {
            int length = lengthFunction.apply(msg);

            if (length > maxLimit) {
                System.out.println("Message too long (" + length + " chars): " + msg);
            } else {
                System.out.println("Message accepted (" + length + " chars): " + msg);
            }
        }
    }
}
