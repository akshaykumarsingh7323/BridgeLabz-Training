package com.medwarehouse;

public class Medicine {
    int expiryDate; 

    public Medicine(int expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return String.valueOf(expiryDate);
    }
}
