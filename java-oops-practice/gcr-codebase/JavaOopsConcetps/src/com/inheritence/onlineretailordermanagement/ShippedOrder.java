package com.inheritence.onlineretailordermanagement;

class ShippedOrder extends Order {
    String trackingNumber;

    ShippedOrder(int orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    String getOrderStatus() {
        return "Order Shipped on " + orderDate + " (Tracking No: " + trackingNumber + ")";
    }
}
