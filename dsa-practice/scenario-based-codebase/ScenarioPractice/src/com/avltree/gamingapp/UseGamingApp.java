package com.avltree.gamingapp;

public class UseGamingApp {

    public static void main(String[] args) {

        AVLLeaderBoard leaderboard = new AVLLeaderBoard();

        leaderboard.insertOrUpdate(1, 450);
        leaderboard.insertOrUpdate(2, 800);
        leaderboard.insertOrUpdate(3, 650);
        leaderboard.insertOrUpdate(4, 900);
        leaderboard.insertOrUpdate(5, 700);

        leaderboard.showTopPlayers();

        System.out.println("\nRemoving player with score 650");
        leaderboard.removePlayer(650);

        leaderboard.showTopPlayers();
    }
}

