package com.objectmodeling.accountmanagement;

import java.util.*;

class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    // Communication method
    public void viewBalance() {
        System.out.println("Customer: " + name);
        for (Account acc : accounts) {
            System.out.println(
                "Bank: " + acc.getBank().getBankName() +
                " | Balance: ₹" + acc.getBalance()
            );
        }
    }
}

