package com.digitalbookstoresystem;

public class UseBookBazzar {

    public static void main(String[] args) {

        Book ebook = new EBook("Java Mastery", "James Gosling", 500, 50);
        Book pbook = new PrintedBook("Clean Code", "Robert Martin", 800, 20);

        Order order = new Order("Akshay");

        order.addBook(ebook, 2);
        order.addBook(pbook, 2);

        System.out.println("Total Amount: Rs " + order.calculateTotal());
        System.out.println("Order Status: " + order.getStatus());
    }
}
