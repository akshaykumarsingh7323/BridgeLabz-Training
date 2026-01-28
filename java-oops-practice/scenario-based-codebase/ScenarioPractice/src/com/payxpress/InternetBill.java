package com.payxpress;

class InternetBill extends Bill {

    InternetBill(double amount, String dueDate) {
        super("Internet", amount, dueDate);
    }

    public void sendReminder() {
        System.out.println("Internet Bill Reminder: Avoid disconnection, pay before " + getDueDate());
    }
}
