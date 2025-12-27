import java.util.*;

public class RajResultGenerator{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int total = 0;
        int marks;
        double average;
        int gradeKey;

        for(int i = 1; i <= 5; i++){
           System.out.print("Enter marks of subject " + i + ": ");
           marks = sc.nextInt();
           total = total + marks;
        }

        average = total / 5.0;
        System.out.println("Average Marks: " + average);

        gradeKey = (int) (average / 10);

        switch(gradeKey){
            case 10:
            case 9:
                System.out.println("Grade: A");
                break;
            case 8:
                System.out.println("Grade: B");
                break;
            case 7:
                System.out.println("Grade: C");
                break;
            case 6:
                System.out.println("Grade: D");
                break;
            default:
                System.out.println("Grade: F (Fail)");
        }
    }
}
