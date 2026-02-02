package com.studentinfo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentData {	
	public static void main(String[] args) {
		
		List<Student> students = Arrays.asList(

			    new Student(1, "Rahul", "cse", 20, "Male", "Delhi", 45, "999900001"),
			    new Student(2, "Amit","mechanical", 22, "Male", "Pune", 78, "999900002"),
			    new Student(3, "Neha", "aiml", 21, "Female", "Mumbai", 30, "999900003"),
			    new Student(4, "Akshay", "aiml", 26, "Female", "Bangalore", 55, "999900004"),
			    new Student(5, "Shyam","Electronics", 44, "Male", "Karnataka", 101, "999900005"),
			    new Student(6, "Sneha", "mechanical",16, "Female", "Pune", 60, "999900006"),
			    new Student(7, "Raunak", "aiml",22, "Male", "Mumbai", 90, "999900007"),
			    new Student(8, "Kavya", "Biotech",21, "Female", "Chennai", 25, "999900008"),
			    new Student(9, "Arjun", "mechanical",23, "Male", "Bangalore", 40, "999900009"),
			    new Student(10,"Pooja", "mba",22, "Female", "Karnataka", 70, "999900010")

			);
		
		System.out.println("---------------------------------------------------------");
		System.out.println("--------------- Basic Filtering & Mapping ---------------");
		System.out.println("---------------------------------------------------------\n");
	//	1.Print all students whose rank is less than 50.
		System.out.println("--------- Students with rank less than 50 ---------");
		students.stream().filter(s -> s.getRank() < 50).forEach(System.out::println);
		
	//  2.Print all students whose age is greater than 25.	
		System.out.println("\n--------- Students with age less than 25 ---------");
		students.stream().filter(s -> s.getAge() > 25).forEach(System.out::println);
		
	//	3.Print the names of all students only.
		System.out.println("\n------------------ All Students-------------------");
		students.stream().forEach(s -> System.out.println(s.getName()));
		
	//	4.Print all students belonging to Mechanical Engineering.
		System.out.println("\n------- All Students with mechanical branch -------");
		students.stream().filter(s -> s.getDept().equals("mechanical")).forEach(System.out::println);
		
	//	5.Print all students not from Mumbai.
		System.out.println("\n---------- All Students not from Mumbai -----------");
		students.stream().filter(s -> !s.getCity().equalsIgnoreCase("mumbai")).forEach(System.out::println);
		
		System.out.println("\n---------------------------------------------------------");
		System.out.println("---------------- Sorting & Limiting ---------------------");
		System.out.println("---------------------------------------------------------");
		
	//	1.Sort students by rank (ascending).
		System.out.println("\n---------- Sort student by rank (ascending) -----------");
		students.stream().sorted(Comparator.comparing(Student::getRank)).forEach(System.out::println);
		
	//	2.Sort students by age (descending).
		System.out.println("\n---------- Sort student by age (descending) -----------");
		students.stream().sorted(Comparator.comparing(Student::getAge).reversed()).forEach(System.out::println);
		
	//	3.Print top 5 students based on rank.
		System.out.println("\n---------- Top 5 student based on rank -----------");
		students.stream().sorted(Comparator.comparing(Student::getRank).reversed()).limit(5).forEach(System.out::println);
		
	//	4.Print last 3 students based on rank.
		System.out.println("\n---------- Last 3 student based on rank -----------");
		students.stream().sorted(Comparator.comparing(Student::getRank)).limit(3).forEach(System.out::println);
		
	//	5.Print students sorted by name and then rank.
		System.out.println("\n---------- Sorted by Name -----------");
		students.stream().sorted(Comparator.comparing(Student::getName)).forEach(System.out::println);
		
		System.out.println("\n---------- Sorted by Rank -----------");
		students.stream().sorted(Comparator.comparing(Student::getRank)).forEach(System.out::println);
		
		System.out.println("\n---------------------------------------------------------");
		System.out.println("---------------- Grouping & Aggregation ---------------------");
		System.out.println("---------------------------------------------------------");
		
	//	1.Count the number of students in each department.
		System.out.println("\n---------- Number of student in each department ----------");
		Map<String, Long> groupedByDept=  students.stream().collect(Collectors.groupingBy(Student::getDept, Collectors.counting()));
		groupedByDept.forEach((dept, count) -> System.out.println(dept + " -> " + count));  
		
	//	2.Count the number of students in each city.
		System.out.println("\n---------- Number of student in each city ----------");
		Map<String, Long> groupedByCity =  students.stream().collect(Collectors.groupingBy(Student::getCity, Collectors.counting()));
		groupedByCity.forEach((city, count) -> System.out.println(city + " -> " + count)); 
		
	//	3.Find the average age of students in each department
		System.out.println("\n---------- Average age by dept ----------");
		Map<String, Double> avgAgeByDept =
		        students.stream()
		                .collect(Collectors.groupingBy(
		                        Student::getDept,
		                        Collectors.averagingInt(Student::getAge)
		                ));

		avgAgeByDept.forEach((dept, avgAge) ->
		        System.out.println(dept + " -> " + avgAge)
		);
		
	//	4.Find the average rank of students by gender.
		System.out.println("\n---------- Average rank by gender ----------");
		Map<String, Double> avgRankByGender =
		        students.stream()
		                .collect(Collectors.groupingBy(
		                        Student::getGender,
		                        Collectors.averagingInt(Student::getRank)
		                ));

		avgRankByGender.forEach((gender, avgRank) ->
		        System.out.println(gender + " -> " + avgRank)
		);
		
	//	5.Find the total number of students in the organization.
		System.out.println("\n---------- Total number of stuents in organization ----------");
		long count = students.stream().count();
		System.out.println("Total number of students : " + count);
		
	//	6.Find the department with the highest average rank
		System.out.println("\n---------- department with highest average rank ----------");
		Map.Entry<String, Double> avgRank=students.stream()
				.collect(Collectors.groupingBy(Student::getDept, Collectors.averagingInt(Student::getRank)))
				.entrySet().stream().max(Map.Entry.comparingByValue()).get();
		System.out.println("Department with highest average rank : " + avgRank);
		
		System.out.println("\n---------------------------------------------------------");
		System.out.println("----------- Min / Max / Ranking Problems ----------------");
		System.out.println("---------------------------------------------------------\n");
		
	//	1.Find the student with the best (lowest) rank.
		System.out.println("Student with lowest rank : " + students.stream().min(Comparator.comparing(Student::getRank)).get());
		
	//	2.Find the student with the worst (highest) rank.
		System.out.println("\nStudent with highest rank : " + students.stream().max(Comparator.comparing(Student::getRank)).get());
		
	//	3.Find the second best rank holder.
		System.out.println("\nStudent with second best rank : " + students.stream().sorted(Comparator.comparing(Student::getRank))
				.skip(1).min(Comparator.comparing(Student::getRank)).get());
		
	//	4.Find the third best rank holder.
		System.out.println("\nStudent with third best rank : " + students.stream().sorted(Comparator.comparing(Student::getRank))
				.skip(2).min(Comparator.comparing(Student::getRank)).get());
		
	//	5.Find the youngest student
		System.out.println("\nYoungest Student : " + students.stream().min(Comparator.comparing(Student::getAge)).get());
		
	//	6.Find the oldest student
		System.out.println("\nOldest Student : " + students.stream().max(Comparator.comparing(Student::getAge)).get());
		
		System.out.println("\n---------------------------------------------------------");
		System.out.println("--------------- FlatMap & Collections -------------------");
		System.out.println("---------------------------------------------------------\n");
		
	//	1.Print all contact numbers of all students
		System.out.println("--------- all contact numbers of all students ----------");
		students.stream().map(Student::getContacts).forEach(System.out::println);
		
	//	2.Count the total number of contact numbers.
		System.out.println("\n--------- Total number of contact numbers ----------");
		Long contactCounts = students.stream().map(Student::getContacts).count();
		System.out.println("Total number of contacts : " + contactCounts);
		
	//	3.Find students who have more than one contact number.
		
	//	4.Print unique contact numbers.
		System.out.println("\n------------- Unique Contacts----------");
		students.stream().map(Student::getContacts).distinct().forEach(System.out::println);
		
		System.out.println("\n---------------------------------------------------------");
		System.out.println("--------------- Conditional & Matching ------------------");
		System.out.println("---------------------------------------------------------\n");
		
	//	1.Check if any student belongs to Biotech Engineering.
		System.out.println("\n------------- student belongs to Biotech Engineering ----------");
		Long checkDept = students.stream().filter(s -> s.getDept().equalsIgnoreCase("Biotech")).count();
		if(checkDept > 0) System.out.println(checkDept + " , student belong to Biotech Engineering");
		else System.out.println("No student belong to Biotech Engineering");
		
	//	Check if all students are above age 20.
		System.out.println("\n------------- student belongs to Biotech Engineering ----------");
		Long checkAge = students .stream().filter(s -> s.getAge() > 20).count();
		if(checkAge == 10) System.out.println("All students are above age 20 ");
		else System.out.println("All students are not above age 20 only  " + checkAge + " students are above age 20.");
		
	//	3.Check if no student belongs to Civil Engineering
		System.out.println("\n------------- check no student belong to civil engineering ----------");
		Long countCivilEng = students.stream().filter(s -> s.getDept().equalsIgnoreCase("civil")).count();
		if(countCivilEng == 0) System.out.println("No students belong to civil engineering");
		else System.out.println(countCivilEng + " students belong to civil engineering");
		
		System.out.println("\n---------------------------------------------------------");
		System.out.println("--------------- Gender-Based Analysis -------------------");
		System.out.println("---------------------------------------------------------\n");
		
	//	1.Count male and female students
		System.out.println("\n------------- Male and Female count ----------");
		Long totalCount = students.stream().count();
		Long maleCount = students.stream().filter(s -> s.getGender().equalsIgnoreCase("male")).count();
		System.out.println("Numbers of Male: " + maleCount);
		System.out.println("Numbers of Female: " + (totalCount - maleCount));
		
	//	Find the average age of male students.
		System.out.println("\n------------- Average age of Male ----------");
		System.out.println("Average age of male: " + students.stream().filter(s -> s.getGender().equalsIgnoreCase("male")).collect(Collectors.averagingInt(Student::getAge)));
		
	//	3.Find the average age of female students.
		System.out.println("\n------------- Average age of Female ----------");
		System.out.println("Average age of female: " + students.stream()
				.filter(s -> s.getGender().equalsIgnoreCase("female"))
				.collect(Collectors.averagingInt(Student::getAge)));
		
	//	4.Find the highest ranked male student
		System.out.println("\n------------- Highest Rank of male ----------");
		Optional<Student> highestRank = students.stream()
				.filter(s -> s.getGender().equalsIgnoreCase("male"))
				.max(Comparator.comparing(Student::getRank));
		System.out.println("Hihgest Rank : " + highestRank.get());
		
   //		4.Find the highest ranked female student
		System.out.println("\n------------- Highest Rank of female ----------");
		highestRank = students.stream()
				.filter(s -> s.getGender().equalsIgnoreCase("female"))
				.max(Comparator.comparing(Student::getRank));
		System.out.println("Hihgest Rank : " + highestRank.get());
		
		System.out.println("\n---------------------------------------------------------");
		System.out.println("----------- Department-Specific Queries -----------------");
		System.out.println("---------------------------------------------------------\n");
		
	//	1.List students department-wise with names only.
		System.out.println("\n------------- Student department-wise ----------");
		Map <String, List<Student>> studentList = students.stream().collect(Collectors.groupingBy(Student::getDept));
		studentList.forEach((dept, list) -> {
			System.out.print("\n" + dept +" -> ");
		    list.forEach(s -> {
		    	System.out.print(s.getName()+ " ");
		    });
		});
		
	//	2.Find the youngest student in Computer Engineering.
		System.out.println("\n\n------------- Youngest student in CSE ----------");
		Optional<Student> youngestStudent = students.stream()
				.filter(s -> s.getDept().equalsIgnoreCase("cse"))
				.min(Comparator.comparing(Student::getAge));
		if(youngestStudent.isPresent()) System.out.println("Youngest Student in CSE department is: " + youngestStudent.get().getName());
		else System.out.println("No student found!");
		
	//	3.Find the top-ranked student in Mechanical Engineering
		System.out.println("\n\n------------- top ranked student in mechanical engineering ----------");
		Optional<Student> topRankedInMechanical = students.stream()
				.filter(s -> s.getDept().equalsIgnoreCase("mechanical"))
				.min(Comparator.comparing(Student::getRank));
		if(topRankedInMechanical.isPresent()) System.out.println("Top ranked student in mechanical engineering: " + topRankedInMechanical.get().getName());
		else System.out.println("No student found!");
		
	//	4.Count students in Electronics Engineering from Karnataka.
		System.out.println("\n\n------------- number of students in electrical engineering ----------");
		Long numberOfStudentInElectronic = students.stream().filter(s -> s.getDept().equalsIgnoreCase("Electronics"))
				.filter(s -> s.getCity().equalsIgnoreCase("Karnataka")).count();
		if(numberOfStudentInElectronic > 0) System.out.println("students in Electronics Engineering from Karnataka : " + numberOfStudentInElectronic);
		else System.out.println("No students found!");
		
		System.out.println("\n---------------------------------------------------------");
		System.out.println("------------------- Advanced Level ----------------------");
		System.out.println("---------------------------------------------------------\n");
		
	//	1.Convert the student list into a Map<Id, Name>.
		System.out.println("---------- list to Map<Id, Name> ----------");
		Map<Integer, String> student1 = students.stream().collect(Collectors.toMap(Student::getId, Student::getName));
		System.out.println("ID -> Name" );
		student1.forEach((id, name) -> {
			System.out.println(id + " -> " + name);
		});
		
	//	2.Convert the student list into a Map<Department, List<Student>>.
		System.out.println("\n---------- list to Map<Department, List<Student> ----------");
		Map<String, List<Student>> student2 = students.stream().collect(Collectors.groupingBy(Student::getDept));
		student2.forEach((dept, list) -> {
			System.out.print("\n" + dept + " -> ");
			list.forEach(name -> {
				System.out.print(name.getName() + " ");
			});
		});
		
	//	3.Find students whose name starts with ‘S’.
		System.out.println("\n\n------------- students whose name starts with ‘S’ ------------");
		List<Student>name =  students.stream().filter(s -> s.getName().toLowerCase().startsWith("s")).collect(Collectors.toList());
		name.forEach(s -> System.out.println(s.getName()));
		
	//	4.Find students whose name length is greater than 5.
		System.out.println("\n-------- students whose name length is greater than 5 --------");
		students.stream().filter(s -> s.getName().length() > 5).map(Student::getName).forEach(System.out::println);
		
	//	5.Find students whose rank is even.
		System.out.println("\n-------- students whose rank is even --------");
		students.stream().filter(s -> s.getRank() % 2 == 0).map(Student::getName).forEach(System.out::println);
		
	//	6.Find students whose rank is odd.
		System.out.println("\n-------- students whose rank is odd --------");
		students.stream().filter(s -> s.getRank() % 2 != 0).map(Student::getName).forEach(System.out::println);
		
		System.out.println("\n---------------------------------------------------------");
		System.out.println("------------------- Bonus Challenges ----------------------");
		System.out.println("---------------------------------------------------------\n");
		
	//	1.Find the top 3 youngest students.
		System.out.println("\n-------- top 3 youngest students --------");
		students.stream().sorted(Comparator.comparing(Student::getAge)).limit(3).map(Student::getName).forEach(System.out::println);
		
	//	2.Find the top 3 oldest students.
		System.out.println("\n-------- top 3 oldest students --------");
		students.stream().sorted(Comparator.comparing(Student::getAge).reversed()).limit(3).map(Student::getName).forEach(System.out::println);
		
	//	3.Partition students based on age > 25.
		System.out.println("\n-------- Partition students based on age > 25 --------");
		Map<Boolean, List<Student>> partitionedStudents1 = students.stream().collect(Collectors.partitioningBy(s -> s.getAge() > 25));
		System.out.println("\nAge greater than 25");
		partitionedStudents1.get(true).stream().map(Student::getName).forEach(System.out::println);
		System.out.println("\nAge less than 25");
		partitionedStudents1.get(false).stream().map(Student::getName).forEach(System.out::println);
		
	//	4.Partition students based on rank < 100.
		Map<Boolean, List<Student>> partitionedStudents2 = students.stream().collect(Collectors.partitioningBy(s -> s.getRank() < 100));
		System.out.println("\nRank less than 100");
		partitionedStudents2.get(true).stream().map(Student::getName).forEach(System.out::println);
		System.out.println("\nRank greater than 100");
		partitionedStudents2.get(false).stream().map(Student::getName).forEach(System.out::println);
		
	//	5.Find the city having maximum students.
		System.out.println("\n------ City having maximum students ------");
		Optional<Map.Entry<String, Long>> result1 =
		        students.stream().collect(Collectors.groupingBy(Student::getCity,Collectors.counting()))
		                .entrySet()
		                .stream()
		                .max(Map.Entry.comparingByValue());
		result1.ifPresent(entry -> System.out.println("City with maximum students: " + entry.getKey() + " = " + entry.getValue()));
		
	//	6.Find the department having minimum students.
		System.out.println("\n------ Department having minimum students ------");
		Optional<Map.Entry<String, Long>> result2 =
		        students.stream().collect(Collectors.groupingBy(Student::getDept,Collectors.counting()))
		                .entrySet()
		                .stream()
		                .min(Map.Entry.comparingByValue());
		result2.ifPresent(entry -> System.out.println("Department with minimum students: " + entry.getKey() + " = " + entry.getValue()));

	}
}
