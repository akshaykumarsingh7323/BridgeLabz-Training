package com.emergencypatientnavigation;

class UnitNode {
    String unitName;
    boolean available;
    UnitNode next;

    UnitNode(String unitName, boolean available) {
        this.unitName = unitName;
        this.available = available;
    }
}


