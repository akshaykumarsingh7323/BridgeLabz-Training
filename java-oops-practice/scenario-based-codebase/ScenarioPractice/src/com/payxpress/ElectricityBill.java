package com.payxpress;

class ElectricityBill extends Bill {

    ElectricityBill(double amount, String dueDate) {
        super("Electricity", amount, dueDate);
    }

    public void sendReminder() {
        System.out.println("Electricity Bill Reminder: Pay before " + getDueDate());
    }
}
