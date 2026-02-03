package com.collectors.orderrevenuesummary;

import java.util.*;
import java.util.stream.Collectors;

public class OrderRevenueSummary {

    public static void main(String[] args) {

        List<Order> orders = List.of(
                new Order("Akshay", 1200.50),
                new Order("Rahul", 800.00),
                new Order("Akshay", 300.00),
                new Order("Neha", 1500.00),
                new Order("Rahul", 200.00),
                new Order("Neha", 800.00)
        );

        Map<String, Double> revenueByCustomer =
                orders.stream()
                      .collect(Collectors.groupingBy(
                              Order::getCustomerName,
                              Collectors.summingDouble(Order::getOrderTotal)
                      ));

        revenueByCustomer.forEach((k, v) ->
                System.out.println(k + " = " + v));
    }
}
