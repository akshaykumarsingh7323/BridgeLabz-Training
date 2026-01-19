package com.generics.onlinemarketplace;

public class UseOnlineMarket {
    public static void main(String[] args) {

        Product<BookCategory> book =
            new Product<>("Java Programming", 500, new BookCategory());

        Product<ClothingCategory> shirt =
            new Product<>("T-Shirt", 800, new ClothingCategory());

        Product<GadgetCategory> phone =
            new Product<>("Smartphone", 25000, new GadgetCategory());

        ProductCatalog catalog = new ProductCatalog();
        catalog.addProduct(book);
        catalog.addProduct(shirt);
        catalog.addProduct(phone);

        System.out.println("Before Discount:");
        catalog.showCatalog();

        DiscountUtil.applyDiscount(book, 10);
        DiscountUtil.applyDiscount(shirt, 20);
        DiscountUtil.applyDiscount(phone, 5);

        System.out.println("\nAfter Discount:");
        catalog.showCatalog();
    }
}
