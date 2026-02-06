package com.java8conversion.listtomapconversion;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//2.Convert List of integers to Map with number and its square
public class IntegerToMap {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		Map<Integer, Integer>map = list.stream().collect(Collectors.toMap(e -> e, e -> e*e));
		System.out.println(map);
	}
}
