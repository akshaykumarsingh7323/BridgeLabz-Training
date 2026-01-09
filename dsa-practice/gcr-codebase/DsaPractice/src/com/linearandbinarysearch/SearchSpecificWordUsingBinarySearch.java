package com.linearandbinarysearch;

import java.util.Scanner;

public class SearchSpecificWord {
	static String checkSpecificWord(String str[], String word, boolean found) {
		for(String sentence : str) {
			if(sentence.contains(word)) {
				found = true;
				return sentence;
			}
		}
		found = false;
		return "Not Found";
	}
	public static void main(String args []) {
		Scanner sc = new Scanner(System.in);
		boolean found = true;
		System.out.println("Enter Number of sentence: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		String str [] = new String[n];
		System.out.println("Enter " + n + " sentence");
		
		for(int i = 0; i < str.length; i++) {
			str[i] = sc.nextLine().toLowerCase();
		}
		
		System.out.println("Enter a word to search: ");
		String word = sc.next().toLowerCase();
		
		String result = checkSpecificWord(str, word, found);
		
		if(found) System.out.println("\"" + word + "\"" + " found in sentence " + "\"" + result + "\"");
		else System.out.println(result);
	}
	
}
