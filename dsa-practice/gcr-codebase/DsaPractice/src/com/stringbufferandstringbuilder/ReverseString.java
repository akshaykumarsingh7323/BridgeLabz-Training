package com.stringbufferandstringbuilder;

import java.util.Scanner;

public class ReverseString {
	public static void main(String args []) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a String: ");
		String str = sc.next();
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(str);
		
		System.out.println("Before reverse: " + str);
		System.out.println("After reverse: " + sb.reverse());
	}
}
