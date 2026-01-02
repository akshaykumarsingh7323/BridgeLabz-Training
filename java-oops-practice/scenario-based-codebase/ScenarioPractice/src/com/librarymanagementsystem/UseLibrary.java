package com.librarymanagementsystem;

import java.util.Scanner;

public class UseLibrary {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter member name: ");
        String name = sc.nextLine();

        Member member = new Member(name);
        Book book = new Book(101, "Java Programming");

        member.issueBook(book);

        System.out.print("Enter late days: ");
        int lateDays = sc.nextInt();

        member.returnBook(book, lateDays);

        sc.close();
    }
}
