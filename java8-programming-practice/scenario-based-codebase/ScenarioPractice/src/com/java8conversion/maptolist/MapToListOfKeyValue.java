package com.java8conversion.maptolist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

// 4.Convert Map to List of key-value strings
public class MapToListOfKeyValue {
	public static void main(String[] args) {
		Map<Integer, String> employees =  new HashMap<>();
		employees.put(1, "Akshay");
		employees.put(2, "Deepanshu");
		employees.put(3, "Priyanshu");
		employees.put(4, "Avinash");
		
		List<String> list = employees.entrySet().stream().map(e -> e.getKey() + " - " + e.getValue()).collect(Collectors.toList());
		System.out.println(list);
	}
}
