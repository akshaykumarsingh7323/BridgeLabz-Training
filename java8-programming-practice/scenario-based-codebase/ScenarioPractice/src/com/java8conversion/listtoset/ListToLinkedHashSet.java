package com.java8conversion.listtoset;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//2.Convert List to LinkedHashSet (preserve order)
public class ListToLinkedHashSet {
	public static void main(String[] args) {
		// list all duplicate
		List<Integer> list = Arrays.asList(10,9,8,7,6,1,2,3,4,5);
		System.out.println("Original List : " + list);
		
		// it does not maintain insertion order
		Set<Integer> set = list.stream().collect(Collectors.toSet());
		System.out.println("Set : " + set);
		
		// it maintain insertion order and does not allow duplicate
		LinkedHashSet<Integer> linkedHashSet = list.stream().collect(Collectors.toCollection(LinkedHashSet::new));
		System.out.println("LinkedHashSet : " + linkedHashSet);
	}
}
