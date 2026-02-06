package com.java8conversion.listtoset;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// 6.Convert Set of objects to List of names
class Person{
	int id;
	String name;
	
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
}

public class SetOfObjectToNameList {
	public static void main(String[] args) {
		Set<Person> persons = Set.of(
			new Person(1, "Akshay"), 
			new Person(2, "Amit"), 
			new Person(3, "Aman"), 
			new Person(4, "Akash"),
			new Person(5, "Ankit")
		);
		
		List<String>names = persons.stream().map(Person::getName).collect(Collectors.toList());
		System.out.println(names);
	}
}
