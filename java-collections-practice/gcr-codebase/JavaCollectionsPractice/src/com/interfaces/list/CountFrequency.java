package com.interfaces.list;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountFrequency {
	
	static Map<String, Integer> findFrequency(List<String>list){
		Map<String, Integer> hashMap = new HashMap<>();
		for(String item : list) {
			if(hashMap.containsKey(item)) {
				hashMap.put(item, hashMap.get(item) + 1);
			}else {
				hashMap.put(item, 1);
			}
		}		
		return hashMap;
	}
	
	public static void main(String[] args) {
		List <String> list = Arrays.asList("Apple", "Banana", "Apple", "Orange");
		Map <String, Integer> result = findFrequency(list);
		System.out.println(result);
	}
}
