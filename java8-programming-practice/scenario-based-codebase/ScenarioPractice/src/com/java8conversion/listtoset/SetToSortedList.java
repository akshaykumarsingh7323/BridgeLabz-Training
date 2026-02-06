package com.java8conversion.listtoset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SetToSortedList {
	public static void main(String[] args) {
		Set<Integer>set = new HashSet<>(Arrays.asList(1,2,3,12,43,11,4,5,6,7,6,5,4,3,2,8,9,10));
		System.out.println("Original Set : " + set);
		
		List<Integer> list = set.stream().sorted().collect(Collectors.toList());
		System.out.println("Sorted List : " + list);
		
		// we can also sort like this
		List<Integer> list2 = new ArrayList<>(set);
		Collections.sort(list);
	}
}
