// Find the Longest Word in a Sentence

import java.util.*;
public class FindLongestWord{

    static String longestWord(String str){
       String words [] = str.split(" "); 
       String longest = "";
       for(String word : words){
	  if(word.length() > longest.length()){
	      longest = word;
	   }
       } 
	return longest.toString(); 
    }

    public static void main(String args []){
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter a text: ");
	String str = sc.nextLine();
	System.out.println("The longest word is " + longestWord(str));
    }
}