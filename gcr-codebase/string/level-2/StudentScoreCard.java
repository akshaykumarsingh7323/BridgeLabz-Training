// write a program to Compute the percentage

import java.util.*;

public class StudentScoreCard{

    public static int[][] generatePCMMarks(int students){
        int[][] marks = new int[students][3];
        Random r = new Random();

        for(int i = 0; i < students; i++){
            for(int j = 0; j < 3; j++) {
                marks[i][j] = r.nextInt(90) + 10; 
            }
        }
        return marks;
    }

    public static double[][] calculateResult(int[][] marks){
        double[][] result = new double[marks.length][3];

        for(int i = 0; i < marks.length; i++){
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double avg = total / 3.0;
            double percent = (total / 300.0) * 100;

            result[i][0] = total;
            result[i][1] = Math.round(avg * 100.0) / 100.0;
            result[i][2] = Math.round(percent * 100.0) / 100.0;
        }
        return result;
    }

    public static char findGrade(double percentage){
        if (percentage >= 80) return 'A';
        else if (percentage >= 70) return 'B';
        else if (percentage >= 60) return 'C';
        else if (percentage >= 50) return 'D';
        else if (percentage >= 40) return 'E';
        else return 'R';
    }

    public static void displayScoreCard(int[][] marks, double[][] result) {
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Stu\tPhy\tChem\tMath\tTotal\tAvg\t\t%\t\tGrade");
        System.out.println("---------------------------------------------------------------------");

        for (int i = 0; i < marks.length; i++) {
            char grade = findGrade(result[i][2]);
            System.out.println((i + 1) + "\t" +
                    marks[i][0] + "\t" +
                    marks[i][1] + "\t" +
                    marks[i][2] + "\t" +
                    (int) result[i][0] + "\t" +
                    result[i][1] + "\t\t" +
                    result[i][2] + "\t\t" +
                    grade);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] marks = generatePCMMarks(n);
        double[][] result = calculateResult(marks);

        displayScoreCard(marks, result);
    }
}