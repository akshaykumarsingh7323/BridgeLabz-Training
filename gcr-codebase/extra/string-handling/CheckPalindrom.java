// Palindrome String Check

import java.util.*;
public class CheckPalindrom{

	public static String reverse(String s){
	   String reverse = "";
	   for(int i = s.length() - 1; i>=0; i--){
	      reverse = reverse + s.charAt(i);   
	   }
         return reverse;
	}
	
    public static void main(String args []){
	Scanner sc = new Scanner(System.in);

	System.out.println("Enter a String: ");
	String str = sc.nextLine();
	
	str = str.toUpperCase();

	String reverse = reverse(str);
	boolean result = str.equalsIgnoreCase(reverse);
	
	if(result){
	   System.out.println("It is Palindrome");
	}else{
	   System.out.println("It is Not Palindrome");
	}
    }
}