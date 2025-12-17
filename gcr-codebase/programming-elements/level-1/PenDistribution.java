//create class PenDistribution to distrube pen and find remaining pen 
public class PenDistribution {
    public static void main(String[] args) {

        //declare and inialize the value of pen and number of student
        int totalPens = 14;
        int students = 3;
        int pensPerStudent = totalPens / students;
        int remainingPens = totalPens % students;

        // Display the result on the screen
        System.out.println("The Pen Per Student is " + pensPerStudent +
                " and the remaining pen not distributed is " + remainingPens);
    }
}
