package com.mobilegamedistributionplatform;

class ArcadeGame extends Game {

    public ArcadeGame(String title, double price) {
        super(title, "Arcade", price);
    }

    @Override
    public void download(User user) {
        user.addGame(this);
        System.out.println(title + " downloaded (Arcade)");
    }

    @Override
    public void playDemo() {
        System.out.println("Playing fast-paced arcade demo of " + title);
    }
}

