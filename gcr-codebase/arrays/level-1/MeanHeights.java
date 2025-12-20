import java.util.*;

//Create a program to find the mean height of players present in a football team
public class MeanHeights{
    public static void main(String args []){
	
	Scanner kb = new Scanner(System.in);

	// get input from the user
        double heights [] = new double [11];
	System.out.println("Enter height of 11 players: ");
       
	for(int i = 0; i < 11; i++){
	    heights[i] = kb.nextDouble();
	}
	
	double sumTotal = 0.0;
	double mean = 0.0;

	for(int i = 0; i < 11; i++){
	    sumTotal = sumTotal + heights[i];
	}
	
	//find mean and showing the the output
	mean = sumTotal / 11;
	System.out.println("The mean height of players present in a football team is " + mean);
    }
}