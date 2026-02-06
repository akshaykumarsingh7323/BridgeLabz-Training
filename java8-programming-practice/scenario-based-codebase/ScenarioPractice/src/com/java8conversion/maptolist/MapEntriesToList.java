package com.java8conversion.maptolist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 3.Convert Map entries to List
class Employee{
	int id;
	String name;
	
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;	
	}

	int getId() {
		return id;
	}

	String getName() {
		return name;
	}

}
public class MapEntriesToList {
	public static void main(String[] args) {
		Map<Integer, String> employees =  new HashMap<>();
		employees.put(1, "Akshay");
		employees.put(2, "Deepanshu");
		employees.put(3, "Priyanshu");
		employees.put(4, "Avinash");
		
		
		List<Map.Entry<Integer, String>> entryList = employees.entrySet().stream().collect(Collectors.toList());
//		System.out.println(entryList);
		System.out.println("Id  Name");
		entryList.forEach(list -> System.out.println(list));
	}
}
