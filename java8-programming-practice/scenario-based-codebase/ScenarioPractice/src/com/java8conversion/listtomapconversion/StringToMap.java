package com.java8conversion.listtomapconversion;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 1.Convert List of strings to Map with string as key and length as value
public class StringToMap {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Akshay", "Aman", "Deepanshu", "Priyanshu", "Avinash");
		
		Map<String, Integer> map = list.stream().collect(Collectors.toMap(word -> word, String::length));
		
		System.out.println(map);
	}
}
