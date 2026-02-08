package com.multithreading.restaurantorderprocessingsystem;

class Chef extends Thread {

    private String dish;
    private long cookingTime; 

    public Chef(String name, String dish, long cookingTime) {
        super(name);               
        this.dish = dish;
        this.cookingTime = cookingTime;
    }

    @Override
    public void run() {

        System.out.println(getName() + " started preparing " + dish);

        int[] progressSteps = {25, 50, 75, 100};
        long stepTime = cookingTime / progressSteps.length;

        for (int progress : progressSteps) {
            try {
                Thread.sleep(stepTime);  
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(getName() + " preparing " + dish +
                    ": " + progress + "% complete");
        }

        System.out.println(getName() + " completed " + dish);
    }
}
