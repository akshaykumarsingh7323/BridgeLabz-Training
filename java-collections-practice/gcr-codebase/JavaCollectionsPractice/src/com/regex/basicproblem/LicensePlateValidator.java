package com.regex.basicproblem;

public class LicensePlateValidator {

    public static void main(String[] args) {
        String[] plates = {
            "AB1234",
            "A12345",
            "ab1234",
            "ABC123",
            "XY9876"
        };

        String regex = "^[A-Z]{2}\\d{4}$";

        for (String plate : plates) {
            if (plate.matches(regex)) {
                System.out.println(plate + " → Valid");
            } else {
                System.out.println(plate + " → Invalid");
            }
        }
    }
}
