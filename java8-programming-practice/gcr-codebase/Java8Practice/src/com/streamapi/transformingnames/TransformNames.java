package com.streamapi.transformingnames;

import java.util.*;

public class TransformNames {

    public static void main(String[] args) {

        List<String> customerNames = Arrays.asList(
                "rahul",
                "amit",
                "neha",
                "pooja"
        );

        customerNames.stream()
                     .map(name -> name.toUpperCase()) 
                     .sorted()                         
                     .forEach(System.out::println);   
    }
}
