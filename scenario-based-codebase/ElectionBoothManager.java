import java.util.*;

public class ElectionBoothManager{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int vote;
        int candidate1 = 0;
        int candidate2 = 0;
        int candidate3 = 0;

        while(true){
            System.out.println("\nEnter your age (or -1 to exit): ");
            int age = sc.nextInt();

            if(age == -1){
                break;
            }

            if(age >= 18){
               System.out.println("You are eligible to vote.");
               System.out.println("Press 1 for Candidate A");
               System.out.println("Press 2 for Candidate B");
               System.out.println("Press 3 for Candidate C");

               vote = sc.nextInt();

               if (vote == 1){
                   candidate1++;
                   System.out.println("Vote recorded for Candidate A");
               }else if (vote == 2){
                   candidate2++;
                   System.out.println("Vote recorded for Candidate B");
                }else if(vote == 3){
                   candidate3++;
                   System.out.println("Vote recorded for Candidate C");
                }else{
                   System.out.println("Invalid vote!");
                }

            }else{
               System.out.println("You are not eligible to vote.");
            }
        }

        System.out.println("\n--- Election Results ---");
        System.out.println("Candidate A Votes: " + candidate1);
        System.out.println("Candidate B Votes: " + candidate2);
        System.out.println("Candidate C Votes: " + candidate3);
    }
}
