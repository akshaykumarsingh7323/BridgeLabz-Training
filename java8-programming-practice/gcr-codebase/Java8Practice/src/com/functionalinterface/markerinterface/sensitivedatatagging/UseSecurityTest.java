package com.functionalinterface.markerinterface.sensitivedatatagging;

public class UseSecurityTest {

    public static void main(String[] args) {

        BankAccount account = new BankAccount("1234567890", 50000);
        Product product = new Product("Laptop", 70000);

        EncryptionProcessor.process(account);
        EncryptionProcessor.process(product);
    }
}
