package com.sorting.productsorting;

import java.util.Scanner;

public class UseFlashDealz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        Product[] products = new Product[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter product name: ");
            String name = sc.nextLine();

            System.out.print("Enter discount percentage: ");
            double discount = sc.nextDouble();
            sc.nextLine(); 
            products[i] = new Product(name, discount);
        }

        QuickSort.quickSort(products, 0, n - 1);

        System.out.println("\nProducts Sorted by Highest Discount:");
        for (Product p : products) {
            System.out.println(p.name + " → " + p.discount + "% OFF");
        }

        sc.close();
    }
}
