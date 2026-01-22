package com.sorting.tailorshop;

import java.util.*;

import com.sorting.registration.Artist;

public class TailorShop {
	void insertionSort(List <Tailor> order) {
		int n = order.size(); 

        for(int i=1; i<n; i++) {
        	Tailor top = order.get(i);
        	int j = i-1;
        	
        	while(j >=0 && order.get(j).getTime().isAfter(top.getTime())) {
        		order.set(j+1, order.get(j));
        		j--;
        	}
        	
        	j++;
        	order.set(j, top);
        }
    }
	
	void displayOrder(List <Tailor> order) {
		if(order.isEmpty()) System.out.println("No order available!!\n");
		else {
			System.out.println("_____________________________________\n");
			for(Tailor t : order) {
				System.out.println(t);
			}
			System.out.println("_____________________________________\n");
		}
	}
}
