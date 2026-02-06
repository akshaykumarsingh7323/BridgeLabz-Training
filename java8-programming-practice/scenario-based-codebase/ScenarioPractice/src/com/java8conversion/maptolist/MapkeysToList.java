package com.java8conversion.maptolist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// convert map keys to list
public class MapkeysToList {
	public static void main(String[] args) {
		Map<Integer, String>map = new HashMap<>();
		map.put(1,"Akshay");
		map.put(2,"Amit");
		map.put(3,"Aman");
		map.put(4,"Akash");
		map.put(5,"Ankit");
		
		List<Integer> keys = map.keySet().stream().collect(Collectors.toList());
		System.out.println("Keys are : " + keys);
		
		List<String> values = map.values().stream().collect(Collectors.toList());
		System.out.println("Values are : " + values);
	}
}
