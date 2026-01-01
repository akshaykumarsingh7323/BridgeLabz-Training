package com.objectmodeling.accountmanagement;

class Bank {
    private String bankName;

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public String getBankName() {
        return bankName;
    }

    public Account openAccount(Customer customer, int accNo) {
        Account account = new Account(accNo, this);
        customer.addAccount(account);
        return account;
    }
}

