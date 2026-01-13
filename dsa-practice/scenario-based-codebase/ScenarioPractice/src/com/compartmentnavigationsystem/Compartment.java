package com.compartmentnavigationsystem;

class Compartment {
    String name;      
    Compartment prev;
    Compartment next;

    public Compartment(String name) {
        this.name = name;
        this.prev = null;
        this.next = null;
    }
}

