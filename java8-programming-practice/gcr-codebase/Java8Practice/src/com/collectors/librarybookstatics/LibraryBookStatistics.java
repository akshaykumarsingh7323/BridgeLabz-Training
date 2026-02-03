package com.collectors.librarybookstatics;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LibraryBookStatistics {
	public static void main(String[] args) {
		List<Book> books = Arrays.asList(
                new Book("Java Basics", "Technology", 450),
                new Book("Spring Boot", "Technology", 550),
                new Book("World History", "History", 600),
                new Book("Ancient India", "History", 500),
                new Book("Space Science", "Science", 700),
                new Book("Physics 101", "Science", 650)
        );
//		find total pages, average pages, and maximum pages per genre.
		Map<String, IntSummaryStatistics>result = books.stream()
				.collect(Collectors.groupingBy(Book::getGenre, Collectors.summarizingInt(Book::getPage)));
		result.forEach((genre, stats) -> {
			System.out.println("Total genre :" + genre);
			System.out.println("Total pages :" + stats.getSum());
			System.out.println("Average pages :" + stats.getAverage());
			System.out.println("Maximum pages :" + stats.getMax());
			System.out.println("-----------------------\n");
		});
	}
}
