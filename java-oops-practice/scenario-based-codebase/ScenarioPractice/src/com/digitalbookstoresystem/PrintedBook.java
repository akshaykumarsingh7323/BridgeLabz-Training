package com.digitalbookstoresystem;

public class PrintedBook extends Book {

    public PrintedBook(String title, String author, double price, int stock) {
        super(title, author, price, stock);
    }

    @Override
    public double applyDiscount(double price, int quantity) {
        return quantity >= 2 ? 100 : 0;
    }
}
