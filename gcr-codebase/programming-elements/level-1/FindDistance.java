import java.util.*;

//create a class FindDistance to find distance in yards and miles
public class FindDistance{
    public static void main(String args []){

        // declare a variabe distance and take input from the user in feet and assign in distance and convert in yards and miles
	Scanner kb = new Scanner(System.in);

        System.out.println("Enter distance in feet:");
	double distance = kb.nextDouble();

	double yards = distance / 3;
	double miles = yards / 1760;

	// Display the result 
	System.out.println("Distance in yards "+yards);
        System.out.println("Distance in miles "+miles);

    }
}


