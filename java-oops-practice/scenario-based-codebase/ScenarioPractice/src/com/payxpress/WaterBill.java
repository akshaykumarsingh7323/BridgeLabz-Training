package com.payxpress;

class WaterBill extends Bill {

    WaterBill(double amount, String dueDate) {
        super("Water", amount, dueDate);
    }

    public void sendReminder() {
        System.out.println("Water Bill Reminder: Save water, pay before " + getDueDate());
    }
}

