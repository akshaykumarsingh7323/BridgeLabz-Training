package com.pharmacyinventorysalessystem;

public interface ISellable {
    double sell(int units);
    boolean checkExpiry();
}
