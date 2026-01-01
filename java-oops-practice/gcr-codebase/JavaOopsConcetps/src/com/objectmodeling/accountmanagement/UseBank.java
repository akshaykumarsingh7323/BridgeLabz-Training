package com.objectmodeling.accountmanagement;

public class UseBank {
    public static void main(String[] args) {

        Bank sbi = new Bank("SBI");
        Bank hdfc = new Bank("HDFC");

        Customer akshay = new Customer("Akshay Kumar Singh");

        Account acc1 = sbi.openAccount(akshay, 101);
        acc1.deposit(5000);

        Account acc2 = hdfc.openAccount(akshay, 202);
        acc2.deposit(12000);

        akshay.viewBalance();
    }
}

