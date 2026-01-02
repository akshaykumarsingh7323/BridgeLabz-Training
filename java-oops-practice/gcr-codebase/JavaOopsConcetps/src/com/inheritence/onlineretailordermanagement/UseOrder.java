package com.inheritence.onlineretailordermanagement;

public class UseOrder {
    public static void main(String[] args) {

        Order o1 = new Order(101, "01-Jan-2026");
        Order o2 = new ShippedOrder(102, "02-Jan-2026", "TRK12345");
        Order o3 = new DeliveredOrder(103, "03-Jan-2026", "TRK67890", "05-Jan-2026");

        System.out.println(o1.getOrderStatus());
        System.out.println(o2.getOrderStatus());
        System.out.println(o3.getOrderStatus());
    }
}
