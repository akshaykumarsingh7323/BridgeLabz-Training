package com.groceryshoppingapp;

interface ICheckout {
    void generateBill();
    void applyDiscount(double couponAmount);
}
