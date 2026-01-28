package com.binarysearchtree.ecommerceproductinventry;

import java.util.Scanner;

public class UseEcommerce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductBST inventory = new ProductBST();
        int choice;

        do {
            System.out.println("\n--- E-Commerce Product Inventory ---");
            System.out.println("1. Add Product");
            System.out.println("2. Search Product (SKU)");
            System.out.println("3. Update Product Price");
            System.out.println("4. Display Products (Sorted by SKU)");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter SKU: ");
                    int sku = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    inventory.insert(new Product(sku, name, price));
                    System.out.println("Product added.");
                    break;

                case 2:
                    System.out.print("Enter SKU to search: ");
                    Product p = inventory.search(sc.nextInt());
                    if (p != null) {
                        System.out.println("Found → " +
                                p.getName() + ", Price: ₹" + p.getPrice());
                    } else {
                        System.out.println("Product not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter SKU: ");
                    int updateSku = sc.nextInt();
                    System.out.print("Enter new price: ");
                    double newPrice = sc.nextDouble();
                    if (inventory.updatePrice(updateSku, newPrice)) {
                        System.out.println("Price updated successfully.");
                    } else {
                        System.out.println("Product not found!");
                    }
                    break;

                case 4:
                    inventory.displaySorted();
                    break;

                case 5:
                    System.out.println("Exiting inventory system...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}