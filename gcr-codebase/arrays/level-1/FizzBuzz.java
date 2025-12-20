import java.util.*;
public class FizzBuzz{
    public static void main(String args []){

        Scanner kb = new Scanner(System.in);
	System.out.println("Enter a number:");
	int number =  kb.nextInt();

	int count = 0;

	if(number <= 0){
	   System.out.println("Please enter a positive number!");
           return;
	}else{
	   for(int i = 0;i <= number; i++){
	      if(i % 3 == 0 || i % 5 == 0){
		   count++;
	      }
	   } 
	}
	
	String str [] = new String[count];
	int index = 0;

	for(int i = 1; i <= number; i++){
 	    if((i % 3 == 0) && (i % 5 == 0)){
		str[index] = "FizzBuzz";
		index++;
	    }else if(i % 5 == 0){
		str[index] = "Buzz";
		index++;
	    }else if(i % 3 == 0){
		str[index] = "Fizz";
		index++;
	    }
	}

	for(int i = 0; i < index; i++){
	   System.out.println(str[i] + " ");
	}
    }
}