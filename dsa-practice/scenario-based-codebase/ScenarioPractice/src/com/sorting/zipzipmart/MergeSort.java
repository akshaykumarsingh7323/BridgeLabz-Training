package com.sorting.zipzipmart;

import java.util.LinkedList;

public class MergeSort {
	static void mergeSort(Transaction [] list, int st, int end) {
		if(st <= end) {
			int mid = (st + end)/2;
			mergeSort(list, st, mid);
			mergeSort(list, mid+1, end);
			merge(list, st, mid, end);
		}
	}
	
	static void merge(Transaction [] list, int st, int mid, int end) {
		
		// findind size of temp array
		int n1 = mid - st + 1;
		int n2 = end - mid;
		
		Transaction[] L = new Transaction[n1];
		Transaction[] R = new Transaction[n1];
		
		for(int i = 0; i < n1; i++) 
			L[i] = list[st + i];
		
		for(int j = 0; j < n2; j++) 
			R[j] = list[mid + 1 + j];
		
		int i = 0, j = 0, k = st;
		
		while(i < n1 && j < n2) {
			if(L[i].date.compareTo(R[j].date) < 0 || (L[i].date.equals(R[j].date) && L[i].amount <= R[j].amount)) {
				list[k++] = L[i++];
			}else {
				list[k++] = R[j++];
			}
		}
		
		while(i < n1)
			list[k++] = L[i++];
		
		while(j < n2)
			list[k++] = R[j++];
	}
}
