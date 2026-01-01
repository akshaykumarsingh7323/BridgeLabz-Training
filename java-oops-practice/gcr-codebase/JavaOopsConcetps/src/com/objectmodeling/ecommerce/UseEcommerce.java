package com.objectmodeling.ecommerce;

public class UseEcommerce {
    public static void main(String[] args) {

        Product p1 = new Product(1, "Laptop", 55000);
        Product p2 = new Product(2, "Mouse", 800);
        Product p3 = new Product(3, "Keyboard", 1200);

        Customer customer = new Customer(101, "Akshay");

        Order order1 = customer.placeOrder(5001);
        order1.addProduct(p1);
        order1.addProduct(p2);

        Order order2 = customer.placeOrder(5002);
        order2.addProduct(p3);

        customer.showOrders();
    }
}

