package com.inheritence.restaurantmanagementsystem;

class Chef extends Person implements Worker {
    String specialtyDish;

    Chef(String name, int id, String specialtyDish) {
        super(name, id);
        this.specialtyDish = specialtyDish;
    }

    @Override
    public void performDuties() {
        System.out.println("Chef " + name + " is cooking: " + specialtyDish);
    }
}
