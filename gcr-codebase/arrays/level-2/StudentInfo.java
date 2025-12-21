import java.util.*;

// Create a program to find the Marks, Percentage and Grade of a student by taking marks of three subject

public class StudentInfo {
    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

	// Get input from user

        System.out.print("Enter Physics marks: ");
        int physics = kb.nextInt();

        System.out.print("Enter Chemistry marks: ");
        int chemistry = kb.nextInt();

        System.out.print("Enter Maths marks: ");
        int maths = kb.nextInt();

        int total = physics + chemistry + maths;
        double percentage = (total / 300.0) * 100;

        char grade;
        if (percentage >= 80)
            grade = 'A';
        else if (percentage >= 70)
            grade = 'B';
        else if (percentage >= 60)
            grade = 'C';
        else if (percentage >= 50)
            grade = 'D';
        else if (percentage >= 40)
            grade = 'E';
        else
            grade = 'R';

        // Display the Output

        System.out.println("\nTotal Marks: " + total);
        System.out.println("Percentage : " + percentage + " %");
        System.out.println("Grade      : " + grade);
    }
}