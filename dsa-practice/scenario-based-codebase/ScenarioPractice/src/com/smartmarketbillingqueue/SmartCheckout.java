package com.smartmarketbillingqueue;

import java.util.*;

class SmartCheckout {

    private Queue<Customer> customerQueue = new LinkedList<>();

    private HashMap<String, Integer> priceMap = new HashMap<>();
    private HashMap<String, Integer> stockMap = new HashMap<>();

    public SmartCheckout() {
        priceMap.put("Milk", 50);
        priceMap.put("Bread", 40);
        priceMap.put("Eggs", 10);

        stockMap.put("Milk", 10);
        stockMap.put("Bread", 5);
        stockMap.put("Eggs", 30);
    }

    public void addCustomer(Customer customer) {
        customerQueue.offer(customer);
        System.out.println(customer.name + " joined the queue");
    }

    public void processCustomer() {

        if (customerQueue.isEmpty()) {
            System.out.println("No customers in queue");
            return;
        }

        Customer c = customerQueue.poll();
        int total = 0;

        System.out.println("Billing customer: " + c.name);

        for (String item : c.items) {

            if (!priceMap.containsKey(item)) {
                System.out.println(item + " not found");
                continue;
            }

            if (stockMap.get(item) <= 0) {
                System.out.println(item + " out of stock");
                continue;
            }

            total += priceMap.get(item);
            stockMap.put(item, stockMap.get(item) - 1);
        }

        System.out.println("Total Bill = ₹" + total);
    }

    public void displayStock() {
        System.out.println("Current Stock: " + stockMap);
    }
}

