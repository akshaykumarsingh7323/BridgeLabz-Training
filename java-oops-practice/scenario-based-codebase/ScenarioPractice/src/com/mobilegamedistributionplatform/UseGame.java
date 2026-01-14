package com.mobilegamedistributionplatform;

public class UseGame {
    public static void main(String[] args) {

        User user = new User("Akshay", 2000);

        Game g1 = new ArcadeGame("Speed Racer", 500);
        Game g2 = new StrategyGame("Empire Builder", 700);

        g1.applyDiscount(20); 
        g1.playDemo();

        g1.download(user);
        g2.download(user);

        user.showLibrary();
    }
}
