package com.avltree.gamingapp;

public class Player {
    int playerId;
    int score;
    int height;

    Player left, right;

    public Player(int playerId, int score) {
        this.playerId = playerId;
        this.score = score;
        this.height = 1;
    }
}
