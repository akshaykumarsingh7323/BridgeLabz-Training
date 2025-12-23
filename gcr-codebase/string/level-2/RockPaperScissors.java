// Writing a program for Rock-Paper-Scissors 

import java.util.*;

public class RockPaperScissors{

    static String getComputerChoice(){
        int choice = (int)(Math.random() * 3);

        if (choice == 0)
            return "rock";
        else if (choice == 1)
            return "paper";
        else
            return "scissors";
    }

    static String findWinner(String user, String computer){

        if(user.equals(computer))
            return "Draw";

        if(user.equals("rock") && computer.equals("scissors"))
            return "User";
        if(user.equals("rock") && computer.equals("paper"))
            return "Computer";

        if(user.equals("paper") && computer.equals("rock"))
            return "User";
        if(user.equals("paper") && computer.equals("scissors"))
            return "Computer";

        if(user.equals("scissors") && computer.equals("paper"))
            return "User";
        if(user.equals("scissors") && computer.equals("rock"))
            return "Computer";

        return "Invalid";
    }

    static String[][] calculateStats(int userWins, int computerWins, int totalGames){

        String[][] stats = new String[2][3];

        double userPercent = (userWins * 100.0) / totalGames;
        double compPercent = (computerWins * 100.0) / totalGames;

        stats[0][0] = "User";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = String.valueOf(userPercent);

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.valueOf(compPercent);

        return stats;
    }

    static void displayResults(String[][] gameResults, String[][] stats){

        System.out.println("\nGame Results:");
        System.out.println("Game\tUser\tComputer\tWinner");
        System.out.println("--------------------------------------");

        for(int i = 0; i < gameResults.length; i++){
            System.out.println((i + 1) + "\t" +
                    gameResults[i][0] + "\t" +
                    gameResults[i][1] + "\t\t" +
                    gameResults[i][2]);
        }

        System.out.println("\nWin Statistics:");
        System.out.println("Player\tWins\tWin Percentage");
        System.out.println("--------------------------------");

        for(int i = 0; i < stats.length; i++){
            System.out.println(stats[i][0] + "\t" + stats[i][1] + "\t" + stats[i][2] + "%");
        }
    }

    public static void main(String[] args){

        Scanner kb = new Scanner(System.in);

        System.out.print("Enter number of games: ");
        int games = kb.nextInt();

        String[][] gameResults = new String[games][3];

        int userWins = 0;
        int computerWins = 0;

        for(int i = 0; i < games; i++){

            System.out.print("\nGame " + (i + 1) + " - Enter your choice (rock/paper/scissors): ");
            String userChoice = kb.next().toLowerCase();

            String computerChoice = getComputerChoice();
            String winner = findWinner(userChoice, computerChoice);

            gameResults[i][0] = userChoice;
            gameResults[i][1] = computerChoice;
            gameResults[i][2] = winner;

            if(winner.equals("User"))
                userWins++;
            else if (winner.equals("Computer"))
                computerWins++;
        }

        String[][] stats = calculateStats(userWins, computerWins, games);
        displayResults(gameResults, stats);
    }
}
