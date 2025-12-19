import java.util.*;

// Create a class to find find youngest and tallest friend

public class YoungestFriend{
    public static void main(String args []){

	// Get age and height as an input from the user and checking youngest and tallest and display result

	Scanner kb = new Scanner(System.in);

	System.out.println("Enter Age and Height of Amar:");
	int ageOfAmar = kb.nextInt();
	int heightOfAmar = kb.nextInt();  

	System.out.println("Enter Age and Height of Akbar:");
	int ageOfAkbar = kb.nextInt();
	int heightOfAkbar = kb.nextInt(); 

	System.out.println("Enter Age and Height of Anthony:");
	int ageOfAnthony = kb.nextInt();
	int heightOfAnthony = kb.nextInt(); 


	if(ageOfAmar > ageOfAkbar && ageOfAmar > ageOfAnthony){

	   System.out.println("Amar is Youngest");

	}else if(ageOfAkbar > ageOfAmar && ageOfAkbar > ageOfAnthony){

	   System.out.println("Akbar is youngest");

	}
	else if(ageOfAnthony > ageOfAmar && ageOfAnthony > ageOfAkbar){

	   System.out.println("Anthony is youngest");

	}

	if(heightOfAmar > heightOfAkbar && heightOfAmar > heightOfAnthony){

	   System.out.println("Amar is tallest");

	}else if(heightOfAkbar > heightOfAmar && heightOfAkbar > heightOfAnthony){

	   System.out.println("Akbar is tallest");

	}
	else if(heightOfAnthony > heightOfAmar && heightOfAnthony > heightOfAkbar){

	   System.out.println("Anthony is tallest");

	}
    }
}
