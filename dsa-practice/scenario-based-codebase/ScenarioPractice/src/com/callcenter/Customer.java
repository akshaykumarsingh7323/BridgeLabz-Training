package com.callcenter;

class Customer {
    private int customerId;
    private String name;
    private boolean isVIP;

    public Customer(int customerId, String name, boolean isVIP) {
        this.customerId = customerId;
        this.name = name;
        this.isVIP = isVIP;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public boolean isVIP() {
        return isVIP;
    }
}

