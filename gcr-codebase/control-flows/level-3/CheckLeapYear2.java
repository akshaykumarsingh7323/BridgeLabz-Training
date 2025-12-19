import java.util.*;

//create a class to check the leap year by using only && and || operators

public class CheckLeapYear2{
    public static void main(String args []){

	Scanner kb = new Scanner(System.in);

	//input from the user and checking leap year

	System.out.println("Enter a year:");
	int year = kb.nextInt();

        if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){

	   System.out.println(year + " is a Leap Year");

        }else{
  
           System.out.println(year + " is not a Leap Year");
	         
        }
    }
}

