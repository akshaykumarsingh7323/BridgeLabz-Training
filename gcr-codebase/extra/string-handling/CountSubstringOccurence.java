// Find Substring Occurrences

import java.util.*;
public class CountSubstringOccurence{

	public static int countSubstring(String str, String substring){
	    String words [] = str.split(" ");
	    int count = 0;
	    for(String word : words){
	         if(word.equalsIgnoreCase(substring)){
		     count++;
		 }
	    }
	    return count;
	} 


    public static void main(String args []){
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter a string:");
	String str = sc.nextLine();
	System.out.println("Enter a substring: ");
        String substring = sc.next();
	System.out.println("Number of counts of substring is "+ countSubstring(str, substring));
    }
}