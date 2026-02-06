package com.java8conversion.listtoset;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//9.Convert Set to List and reverse order
public class SetToListAndReverseOrder {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>(Arrays.asList(1,2,3,12,43,11,4,5,6,7,6,5,4,3,2,8,9,10));
		System.out.println("Original Set : " + set);
		
		// when we use toList without collectors then it return immutable list, we can't add or change
		List<Integer> list1 = set.stream().toList().reversed();
		System.out.println("\nList using (toList directly) ->: " + list1);
		
		// when we collectors then it give mutable list, we can add or change
		List<Integer> list2 = set.stream().collect(Collectors.toList());
		System.out.println("\nList using (collectors.toList) -> : " + list2);
	}
}
