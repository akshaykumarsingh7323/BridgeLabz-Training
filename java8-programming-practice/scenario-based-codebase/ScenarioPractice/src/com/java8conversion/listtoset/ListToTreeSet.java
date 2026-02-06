package com.java8conversion.listtoset;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.*;

public class ListToTreeSet {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,3,4,6,7,9,12,23,34,54,23,25,31);
		System.out.println("Original list : " + list);
		
		TreeSet<Integer> treeSet = list.stream().collect(Collectors.toCollection(TreeSet::new));
		System.out.println("Sorted : " + treeSet);
	}
}
