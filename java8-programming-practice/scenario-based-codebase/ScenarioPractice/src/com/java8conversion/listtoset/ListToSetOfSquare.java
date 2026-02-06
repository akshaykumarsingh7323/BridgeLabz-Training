package com.java8conversion.listtoset;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ListToSetOfSquare {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,4,5,6);
		System.out.println("Original List " + list);
		
		Set<Integer> set = list.stream().map(e -> e * e).collect(Collectors.toSet());
		System.out.println("\nSquared Set : " + set);
		
	}
}
