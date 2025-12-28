package com.constructor.level1;

public class UsePerson {

	public static void main(String[] args) {
		Person p1 = new Person("Akshay", 21);
		p1.display();
		Person p2 = new Person(p1);
		p2.display();
	}

}
