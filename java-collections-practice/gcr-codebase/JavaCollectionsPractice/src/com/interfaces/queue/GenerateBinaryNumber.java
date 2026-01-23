package com.interfaces.queue;

import java.util.*;


public class GenerateBinaryNumber {
	
	static Queue<String> generateBinary(int n){
		Queue<String> queue = new ArrayDeque<>();
		for(int i = 1; i <= n; i++) {
			queue.add(Integer.toBinaryString(i));
		}
		return queue;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number");
		int n = sc.nextInt();
		Queue<String>queue = generateBinary(n);
		
		System.out.println("Binary number from 1 to " + n + ":");
		System.out.println(queue);
	}
}
