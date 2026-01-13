package com.callcenter;

public class UseCallCenter {
    public static void main(String[] args) {

        CallCenterManager manager = new CallCenterManager();

        Customer c1 = new Customer(101, "Rahul", false);
        Customer c2 = new Customer(102, "Amit", true);
        Customer c3 = new Customer(103, "Neha", false);
        Customer c4 = new Customer(102, "Amit", true);

        manager.addCall(c1);
        manager.addCall(c2);
        manager.addCall(c3);
        manager.addCall(c4);

        manager.displayQueues();

        System.out.println("\nServing Call: " + manager.serveNextCall().getName());
        System.out.println("Serving Call: " + manager.serveNextCall().getName());

        System.out.println("\nAmit Call Count: " + manager.getCallCount(102));
    }
}

