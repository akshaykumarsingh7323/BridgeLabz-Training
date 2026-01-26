package com.junit.advanceproblem.testingbankingtransaction;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount();
    }

    @Test
    void testDeposit() {
        account.deposit(1000);
        assertEquals(1000, account.getBalance());
    }

    @Test
    void testWithdraw() {
        account.deposit(1000);
        account.withdraw(400);

        assertEquals(600, account.getBalance());
    }

    @Test
    void testWithdrawInsufficientBalance() {
        account.deposit(500);

        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(800);
        });
    }

    @Test
    void testMultipleTransactions() {
        account.deposit(1000);
        account.withdraw(200);
        account.deposit(300);

        assertEquals(1100, account.getBalance());
    }
}

