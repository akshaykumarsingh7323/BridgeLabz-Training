package com.sorting.gamerzone;

import java.util.*;

public class UseGamerZone {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        List<Player> players = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            System.out.println("\nPlayer " + i);
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Score: ");
            int score = sc.nextInt();
            sc.nextLine();

            players.add(new Player(name, score));
        }

        QuickSorter.quickSort(players, 0, players.size() - 1);

        System.out.println("\nGamerZone Leaderboard (High to Low):");
        int rank = 1;
        for (Player p : players) {
            System.out.println(rank++ + ". " + p.name + " - " + p.score);
        }
    }
}
