package com.java8conversion.listtoset;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SetToList {
	public static void main(String[] args) {
		// Set.of is immutable and when try to change to remove duplicate then it will give error
		Set<Integer> set = Set.of(18,2,3,34,25,16,26,15,7,8,9,55,77,33);
		System.out.println("Set : " + set);
		List<Integer> list = set.stream().collect(Collectors.toList());
		System.out.println("list : " + list );
		
	}
}
