package com.interfaces.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RotateElement {
	static List<Integer> rotate(List<Integer> list, int k){
		int n = list.size();
		k = k % n;
		
		List <Integer> result = new ArrayList<>();
		
		for(int i = k; i < n; i++) {
			result.add(list.get(i));
		}
		for(int i = 0; i < k; i++) {
			result.add(list.get(i));
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of elements: ");
		int n = sc.nextInt();
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			list.add(sc.nextInt());
		}
		
		System.out.print("Enter rotation point: ");
		int k = sc.nextInt() - 1;
		
		System.out.println(rotate(list,k));
	}
}
