package com.sorting.zipzipmart;

import java.util.Scanner;

public class UseZipZipMart {
	public static void main(String args []) {
		Transaction list[] = {
	            new Transaction("2026-01-15", 500.0),
	            new Transaction("2026-01-14", 1200.0),
	            new Transaction("2026-01-15", 300.0),
	            new Transaction("2026-01-14", 1200.0),
	            new Transaction("2026-01-13", 700.0)
	        };
		System.out.println("\nBefore Sorting:");
		for(Transaction t : list) {
			System.out.println(t);
		}
		MergeSort.mergeSort(list, 0, list.length-1);
	}
}
