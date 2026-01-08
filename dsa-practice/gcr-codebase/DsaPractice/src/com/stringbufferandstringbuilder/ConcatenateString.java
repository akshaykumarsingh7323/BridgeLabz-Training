package com.stringbufferandstringbuilder;

import java.util.Scanner;

public class ConcatenateString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str [] = {"Hello", "World"};
		
		StringBuilder sb = new StringBuilder();
		
		for(String s : str) {
			sb.append(s);
		}
		System.out.println("After Concatenation: " + sb.toString());
	}
}
