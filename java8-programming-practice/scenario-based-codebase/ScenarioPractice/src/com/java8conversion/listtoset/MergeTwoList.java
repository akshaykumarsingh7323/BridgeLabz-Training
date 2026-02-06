package com.java8conversion.listtoset;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//10.Merge two Lists and convert to Set
public class MergeTwoList {
	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(1,2,3,4,5);
		List<Integer> list2 = Arrays.asList(6,7,8,9,10);
		System.out.println("First List : " + list1);
		System.out.println("Second List : " + list2);
		
		Set<Integer> set = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toSet());
		System.out.println("Merged Set : " + set);
	}
}
