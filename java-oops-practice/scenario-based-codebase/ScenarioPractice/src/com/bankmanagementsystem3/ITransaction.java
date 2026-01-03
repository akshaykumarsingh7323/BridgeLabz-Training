package com.bankmanagementsystem3;

interface ITransaction {
    void deposit(double amount);
    void withdraw(double amount);
    double checkBalance();
}
