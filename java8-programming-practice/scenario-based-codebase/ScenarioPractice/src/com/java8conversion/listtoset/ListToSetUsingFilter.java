package com.java8conversion.listtoset;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// 7.Convert List to Set after filtering condition
public class ListToSetUsingFilter {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
		System.out.println("Original list : " + list);
		
		Set<Integer> set = list.stream().filter(e -> e % 2 == 0).collect(Collectors.toSet());
		System.out.println("Filtered set : " + set);
	}
}
