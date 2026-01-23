package com.interfaces.queue;

import java.util.*;

public class ReverseQueue {
	static Queue<Integer> reverseQueue(Queue <Integer> queue) {
		Stack <Integer> stack = new Stack<>();
		
		while(!queue.isEmpty()) {
			stack.add(queue.remove());
		}
		
		while(!stack.isEmpty()) {
			queue.add(stack.pop());
		}
		return queue;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter size of Queue: ");
		int n = sc.nextInt();
		
		Queue<Integer> queue = new ArrayDeque<>();
		System.out.println("Enter " + n + " element for Queue: ");
		for(int i = 0; i < n; i++) {
			queue.add(sc.nextInt());
		}
		
		System.out.println("Original Queue: " + queue);
		
		System.out.println("Reverse Queue: " + reverseQueue(queue));
	}
}
