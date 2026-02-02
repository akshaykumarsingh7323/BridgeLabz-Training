package com.studentinfo;

public class Student {
	String name;
	int id;
	int age;
	String dept;
	String gender;
	String city;
	int rank;
	String contacts;
	
	public Student(int id, String name, String dept, int age, String gender, String city, int rank, String contacts) {
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.age = age;
		this.gender = gender;
		this.city = city;
		this.rank = rank;
		this.contacts = contacts;
	}

	String getName() {
		return name;
	}

	int getId() {
		return id;
	}
	
	String getDept() {
		return dept;
	}

	int getAge() {
		return age;
	}

	String getGender() {
		return gender;
	}

	String getCity() {
		return city;
	}

	int getRank() {
		return rank;
	}

	String getContacts() {
		return contacts;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", age=" + age + ", dept=" + dept + ", gender=" + gender
				+ ", city=" + city + ", rank=" + rank + ", contacts=" + contacts + "]";
	}
	
			
}
