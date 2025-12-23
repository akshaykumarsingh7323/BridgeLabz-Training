// Write a program to check whether the student can vote depending on his/her age is greater or equal to 18.

import java.util.Scanner;

public class VotingEligibility{

    static int[] generateAges(int n){
        int[] ages = new int[n];

        for(int i = 0; i < n; i++){
            ages[i] = (int)(Math.random() * 90) + 10;        }
        return ages;
    }

    static String[][] checkVoting(int[] ages){

        String[][] result = new String[ages.length][2];

        for(int i = 0; i < ages.length; i++){

            result[i][0] = String.valueOf(ages[i]);

            if(ages[i] < 0){
               result[i][1] = "false";
            }else if (ages[i] >= 18){
               result[i][1] = "true";
            }else {
               result[i][1] = "false";
            }
        }
        return result;
    }

    static void displayResult(String[][] data){

        System.out.println("\nAge\tCan Vote");
        System.out.println("----------------");

        for(int i = 0; i < data.length; i++){
            System.out.println(data[i][0] + "\t" + data[i][1]);
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] ages = generateAges(n);
        String[][] votingResult = checkVoting(ages);

        displayResult(votingResult);
    }
}
