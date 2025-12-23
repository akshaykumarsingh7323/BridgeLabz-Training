// Remove Duplicates from a String

import java.util.*;
public class RemoveDuplicate{

   static String removeDuplicate(String s){
        String result = "";
	HashSet <Character> hs = new HashSet <>();
        for(char ch : s.toCharArray()){
	    if(!hs.contains(ch)){
		hs.add(ch);
		result = result + ch;
	    }
        } 
	return result.toString();
    }

   public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter a String: ");
	String str = sc.next();
	String newString = removeDuplicate(str);
	System.out.println("Original string: " + str);
	System.out.println("After removing duplicate string: " + newString);
   }
}