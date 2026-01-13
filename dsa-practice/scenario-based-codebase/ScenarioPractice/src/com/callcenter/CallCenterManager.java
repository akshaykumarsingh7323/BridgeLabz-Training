package com.callcenter;

import java.util.*;

class CallCenterManager {

    private Queue<Customer> vipQueue;
    private Queue<Customer> normalQueue;
    private HashMap<Integer, Integer> callCountMap;

    public CallCenterManager() {
        vipQueue = new LinkedList<>();
        normalQueue = new LinkedList<>();
        callCountMap = new HashMap<>();
    }

    public void addCall(Customer customer) {
        if (customer.isVIP()) {
            vipQueue.offer(customer);
        } else {
            normalQueue.offer(customer);
        }

        int id = customer.getCustomerId();
        callCountMap.put(id, callCountMap.getOrDefault(id, 0) + 1);
    }

    public Customer serveNextCall() {
        if (!vipQueue.isEmpty()) {
            return vipQueue.poll();
        } else if (!normalQueue.isEmpty()) {
            return normalQueue.poll();
        } else {
            System.out.println("No calls in queue");
            return null;
        }
    }

    public int getCallCount(int customerId) {
        return callCountMap.getOrDefault(customerId, 0);
    }

    public void displayQueues() {
        System.out.println("VIP Queue:");
        for (Customer c : vipQueue) {
            System.out.println(c.getName());
        }

        System.out.println("Normal Queue:");
        for (Customer c : normalQueue) {
            System.out.println(c.getName());
        }
    }
}

