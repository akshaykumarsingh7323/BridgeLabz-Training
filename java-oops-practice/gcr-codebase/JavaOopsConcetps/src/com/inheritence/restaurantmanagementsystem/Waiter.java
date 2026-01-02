package com.inheritence.restaurantmanagementsystem;

class Waiter extends Person implements Worker {
    String section;

    Waiter(String name, int id, String section) {
        super(name, id);
        this.section = section;
    }

    @Override
    public void performDuties() {
        System.out.println("Waiter " + name + " is serving in section: " + section);
    }
}
