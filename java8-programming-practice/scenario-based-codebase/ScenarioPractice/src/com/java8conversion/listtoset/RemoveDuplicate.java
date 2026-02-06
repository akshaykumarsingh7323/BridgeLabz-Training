package com.java8conversion.listtoset;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// 1.Convert List to Set (remove duplicates)
public class RemoveDuplicate {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,12,43,11,4,5,6,7,6,5,4,3,2,8,9,10);
		Set<Integer> set = list.stream().collect(Collectors.toSet());
		System.out.println(set);
	}
}
