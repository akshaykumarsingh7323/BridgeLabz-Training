import java.util.*;

public class FriendInfo{
    public static void main(String args []){

	Scanner kb = new Scanner(System.in);

	String[] names = {"Amar", "Akbar", "Anthony"};
	int ages [] = new int [3];
	int heights [] = new int [3];

	for(int i = 0; i<3; i++){
	    System.out.print("Enter age of " + names[i] + ": ");;
	    ages[i] = kb.nextInt();
	    System.out.print("Enter height of " + names[i] + " (in cm): ");
	    heights[i] = kb.nextInt();
	}
	
	int youngestIndex = 0;
        int tallestIndex = 0;

	for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }

            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }

	System.out.println("Youngest friend: " + names[youngestIndex] + " (Age: " + ages[youngestIndex] + ")");
        System.out.println("Tallest friend: " + names[tallestIndex] + " (Height: " + heights[tallestIndex] + " cm)");
    }
}