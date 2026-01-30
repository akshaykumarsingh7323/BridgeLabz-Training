package com.methodreferences.invoiceobjectcreation;

import java.util.*;
import java.util.stream.Collectors;

public class UseInvoice {

    public static void main(String[] args) {

        List<Integer> transactionIds = List.of(1001, 1002, 1003, 1004);

        List<Invoice> invoices = transactionIds.stream()
                .map(Invoice::new)
                .collect(Collectors.toList());

        invoices.forEach(System.out::println);
    }
}
