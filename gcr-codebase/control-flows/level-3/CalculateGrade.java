import java.util.*;

//create a class to calculate the Average marks and Grade of a Student

public class CalculateGrade{
    public static void main(String args []){

	Scanner kb = new Scanner(System.in);

	//input from the user and assign in physics, chemistry, and maths and find the average marks

	System.out.println("Enter marks of physics:");
	int physics = kb.nextInt();

	System.out.println("Enter marks of chemistry:");
	int chemistry = kb.nextInt();

	System.out.println("Enter marks of physics:");
	int maths = kb.nextInt();

	int totalMarks = physics + chemistry + maths;

	double average = (totalMarks / 300.0) * 100;

	// checking for grade and remarks

	if (average >= 80) {
		System.out.println("Average marks = " + average + ", Grade = A, and remarks = (Level-4, above agency-normalized standards)");
	} else if (average >= 70 && average < 79) {
		System.out.println("Average marks = " + average + ", Grade = B, and remarks = (Level-3, agency-normalized standards)");
	} else if (average >= 60 && average < 69) {
		System.out.println("Average marks = " + average + ", Grade = C, and remarks = (Level-2, below, but approaching agency-normalized standards)");
	} else if (average >= 50 && average < 59) {
		System.out.println("Average marks = " + average + ", Grade = D, and remarks = (Level-1, well below agency-normalized standards)");
	} else if (average >= 40 && average < 49) {
		System.out.println("Average marks = " + average + ", Grade = E, and remarks = (Level-1, to below agency-normalized standards)");
	} else {
		System.out.println("Average marks = " + average + ", Grade = R, and remarks = (Level-4, Remedial standards)");
	}          
    }
}

