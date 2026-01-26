package com.regex.advanceproblem;

public class ValidateCreditCardNumber {
    public static void main(String[] args) {
        String car1 = "4123456789012345";
        String car2 = "3123456789012345";
        String regex = "^(4\\d{15}|5\\d{15})$";

        System.out.println(car1.matches(regex));
        System.out.println(car2.matches(regex));
    }
}

