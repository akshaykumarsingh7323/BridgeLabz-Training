package com.classandobject.Level2;

public class CheckPalindrome {

	String text;
	
	CheckPalindrome(String text) {
		this.text=text;
		
	}

	public boolean isPalindrome() {

		String cleantext=text.replaceAll("\\s","").toLowerCase();

		String reverseText=new StringBuilder(cleantext).reverse().toString();
	
	    return cleantext.equals(reverseText);
	}
	
	public void diplayResult() {
		if(isPalindrome()) {
			System.out.println(text+" is palindrome");
			}
		else {
			System.out.println(text+" is not Palindrome");
		}
	}
	
	public static void main(String[] args) {

		CheckPalindrome checker1 = new CheckPalindrome("A man a plan a canal Panama");
		 checker1.diplayResult();
		
	    CheckPalindrome checker2 = new CheckPalindrome("Hello");
		 checker2.diplayResult();
	}
}

