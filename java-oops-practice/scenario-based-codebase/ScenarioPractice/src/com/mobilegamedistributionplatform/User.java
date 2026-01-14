package com.mobilegamedistributionplatform;

import java.util.ArrayList;

class User {

    private String name;
    private double walletBalance;

    private ArrayList<Game> ownedGames;

    public User(String name, double walletBalance) {
        this.name = name;
        this.walletBalance = walletBalance;
        this.ownedGames = new ArrayList<>();
    }

    protected void addGame(Game game) {
        if (walletBalance >= game.price) {
            walletBalance -= game.price; 
            ownedGames.add(game);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void showLibrary() {
        System.out.println(name + "'s Game Library:");
        for (Game g : ownedGames) {
            System.out.println("- " + g.getTitle());
        }
    }
}
