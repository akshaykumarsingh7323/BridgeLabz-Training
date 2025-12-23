// Reverse a String

import java.util.*;
public class ReverseString{

     public static String reverse(String s){
	 String reverse = " ";
	 for(int i = s.length() - 1; i>=0; i--){
	    reverse = reverse + s.charAt(i);   
	 }
        return reverse;
     }
    public static void main(String args []){

	Scanner sc = new Scanner(System.in);
	System.out.println("Enter a String: ");
	String str = sc.nextLine();

	String reverse = reverse(str);
	

	System.out.println("Original String: " + str);
	System.out.println("Reverse string: " + reverse);
	
    }
}