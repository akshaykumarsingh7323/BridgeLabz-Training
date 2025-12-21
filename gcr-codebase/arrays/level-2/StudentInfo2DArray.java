import java.util.*;


// create a program using 2D array to calculate percentage and grade of a student

public class StudentInfo2DArray {
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = kb.nextInt();

        int[][] marks = new int[n][3];
        double[] percentage = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter Physics marks: ");
            marks[i][0] = kb.nextInt();

            System.out.print("Enter Chemistry marks: ");
            marks[i][1] = kb.nextInt();

            System.out.print("Enter Maths marks: ");
            marks[i][2] = kb.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = (total / 300.0) * 100;

            if (percentage[i] >= 80)
                grade[i] = 'A';
            else if (percentage[i] >= 70)
                grade[i] = 'B';
            else if (percentage[i] >= 60)
                grade[i] = 'C';
            else if (percentage[i] >= 50)
                grade[i] = 'D';
            else if (percentage[i] >= 40)
                grade[i] = 'E';
            else
                grade[i] = 'R';
        }

        // Display result
        System.out.println("\nSTUDENT RESULTS");
        for(int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1));
            System.out.println("Physics   : " + marks[i][0]);
            System.out.println("Chemistry : " + marks[i][1]);
            System.out.println("Maths     : " + marks[i][2]);
            System.out.println("Percentage: " + percentage[i] + " %");
            System.out.println("Grade     : " + grade[i]);
            System.out.println();
        }
    }
}