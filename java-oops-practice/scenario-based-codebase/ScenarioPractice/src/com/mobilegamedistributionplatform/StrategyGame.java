package com.mobilegamedistributionplatform;

class StrategyGame extends Game {

    public StrategyGame(String title, double price) {
        super(title, "Strategy", price);
    }

    @Override
    public void download(User user) {
        user.addGame(this);
        System.out.println(title + " downloaded (Strategy)");
    }

    @Override
    public void playDemo() {
        System.out.println("Playing tactical strategy demo of " + title);
    }
}
