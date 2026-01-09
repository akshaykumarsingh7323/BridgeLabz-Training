package com.stringbufferandstringbuilder;

import java.util.Scanner;

public class CompareStringBufferAndStringBuilder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of Cancatenation: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter String: ");
		String str = sc.nextLine();
		
		StringBuffer stringBuffer = new StringBuffer();
		long startBuffer = System.nanoTime();
		
		for(int i = 0; i < n; i++) {
			stringBuffer.append(str);
		}	
		long endBuffer = System.nanoTime();
		long stringBufferTime = endBuffer - startBuffer;
		
		StringBuilder stringBuilder = new StringBuilder();
		long startBuilder = System.nanoTime();
		
		for(int i = 0; i < n; i++) {
			stringBuilder.append(str);
		}	
		long endBuilder = System.nanoTime();
		long stringBuilderTime = endBuilder - startBuilder;
		
		System.out.println("StringBuffer Time: " + stringBufferTime + " ns");
		System.out.println("StringBuilder Time: " + stringBuilderTime + " ns");
	}
}
