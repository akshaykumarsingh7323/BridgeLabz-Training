package com.functionalinterface.staticmethod.dateformatutility;

import java.time.LocalDate;

public class InvoiceDateUtility {

    public static void main(String[] args) {

        LocalDate invoiceDate = LocalDate.now();

        System.out.println("Invoice Date (dd-MM-yyyy): " + DateUtils.formatDate(invoiceDate, "dd-MM-yyyy"));

        System.out.println("Invoice Date (yyyy/MM/dd): " + DateUtils.formatDate(invoiceDate, "yyyy/MM/dd"));

        System.out.println("Invoice Date (MMM dd, yyyy): " + DateUtils.formatDate(invoiceDate, "MMM dd, yyyy"));
    }
}