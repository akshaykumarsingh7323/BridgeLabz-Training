package com.sorting.smartlibrary;

import java.util.Scanner;

public class UseSmartLibrary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of borrowed books: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        Book[] books = new Book[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter book title " + (i + 1) + ": ");
            String title = sc.nextLine();
            books[i] = new Book(title);
        }

        InsertionSort.sortBooks(books);

        System.out.println("\nBorrowed Books (Alphabetically Sorted):");
        for (Book b : books) {
            System.out.println(b.title);
        }
    }
}

