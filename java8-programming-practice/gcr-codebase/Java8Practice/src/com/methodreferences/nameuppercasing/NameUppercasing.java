package com.methodreferences.nameuppercasing;

import java.util.*;

public class NameUppercasing {

    public static void main(String[] args) {

        List<String> employeeNames =
                List.of("Akshay", "Rohit", "Amit", "Aman");

        employeeNames.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}

