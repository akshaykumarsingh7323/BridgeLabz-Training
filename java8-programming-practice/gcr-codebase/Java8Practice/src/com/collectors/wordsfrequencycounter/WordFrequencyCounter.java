package com.collectors.wordsfrequencycounter;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class WordFrequencyCounter {
	public static void main(String[] args) {
		String str = "Java is powerful and Java is fast akshay Akshay";
		
		String words [] = str.toLowerCase().split(" ");
		Map<String, Integer> wordCount = Arrays.stream(words)
				.collect(Collectors.toMap(word -> word, word -> 1, Integer::sum));
		wordCount.forEach((k, v) -> {
			System.out.println(k + " -> " + v);
		});
	}
}
