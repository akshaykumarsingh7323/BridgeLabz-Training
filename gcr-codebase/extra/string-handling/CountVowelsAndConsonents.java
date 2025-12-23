// Count Vowels and Consonants

import java.util.*;
public class CountVowelsAndConsonents{

     public static int countVowels(String s){
	 int count = 0;
	 for(int i = 0; i<s.length(); i++){
	    char ch = s.charAt(i);
	    if(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
	       count++;
	    }
	 }
        return count;
     }
    public static void main(String args []){

	Scanner sc = new Scanner(System.in);
	System.out.println("Enter a String: ");
	String str = sc.nextLine();
 	str = str.toUpperCase();

	int vowels = countVowels(str);
	int consonents = str.length() - vowels;

	System.out.println("Vowels = " + vowels);
	System.out.println("consonents = " + consonents);
	
    }
}