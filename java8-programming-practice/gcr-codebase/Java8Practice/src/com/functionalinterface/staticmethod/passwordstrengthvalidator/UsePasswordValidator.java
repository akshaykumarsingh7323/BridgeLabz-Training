package com.functionalinterface.staticmethod.passwordstrengthvalidator;

import java.util.Scanner;

public class UsePasswordValidator {

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);

    	System.out.println("Enter your password(atleast 8 character): ");
        String password = sc.nextLine();

        if (SecurityUtils.isStrongPassword(password)) {
            System.out.println("Strong Password");
        } else {
            System.out.println("Weak Password");
        }
    }
}
