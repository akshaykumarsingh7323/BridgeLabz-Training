import java.util.*;

// create a class to take 5 number from the user and check 

public class ArrayNumberCheck{
    public static void main(String args []){

	Scanner kb = new Scanner(System.in);

	int num [] = new int [5];

	// Taking input from the user and assign in array using for loop

	System.out.println("Enter 5 numbers:");
	for(int i = 0; i < 5; i++){
	    num[i] = kb.nextInt();
	}

	for(int i = 0; i < 5; i++){
	    if(num[i] > 0){
	       if(num[i] % 2 == 0){
                  System.out.println(num[i] + " is even number");
	       }else{
	          System.out.println(num[i] + " is odd number");
	       }
	    }else if(num[i] < 0){
		System.out.println(num[i] + "negative number");
	    }else{
	        System.out.println("zero");
	    }
	}

	// comparing number

	if (num[0] == num[num.length - 1]) {
            System.out.println("First and last elements are equal");
        } else if (num[0] > num[num.length - 1]) {
            System.out.println("First element is greater than the last element");
        } else {
            System.out.println("First element is less than the last element");
        }
    }
}

