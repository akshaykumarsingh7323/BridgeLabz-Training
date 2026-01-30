package com.methodreferences.invoiceobjectcreation;

public class Invoice {

    private int transactionId;

    public Invoice(int transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "Invoice generated for Transaction ID: " + transactionId;
    }
}
