package com.foreach.iotsensorreading;

import java.util.*;

public class PrintReading {
	public static void main(String[] args) {
		int threshold = 37;
		
		// Number is abstract so we can't use >= directly in temperature 1
		System.out.println("Temperature1 ");
		List<Number> temperature1 = Arrays.asList(23, 38, 37.5, 36.9, 40, 0, 33);
		temperature1.stream().filter(n -> n.doubleValue() >= threshold).forEach(n -> System.out.println(n));
		
		System.out.println("\nTemperature2 ");
		List<Integer> temperature2 = Arrays.asList(23, 38, 37, 36, 40, 0, 33);
		temperature2.stream().filter(n -> n >= threshold).forEach(n -> System.out.println(n));

	}
}
