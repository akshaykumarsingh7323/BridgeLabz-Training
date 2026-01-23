package com.interfaces.queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();
	public void push(int x) {
		q2.offer(x);
		   
		while(!q1.isEmpty()) {
			q2.add(q1.remove());
		}
		
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;
	}
	
	public int pop() {
		if(q1.isEmpty()) 
			throw new RuntimeException("Stack is Empty");
		return q1.remove();
	}
	
	public int top() {
		if(q1.isEmpty()) 
			throw new RuntimeException("Stack is Empty");
		return q1.peek();
	}
	
	void showElement() {
		for(int n : q1) {
			System.out.print(n + " ");
		}
	}
   public static void main(String[] args) {
	   StackUsingQueue stack = new StackUsingQueue();
	   stack.push(1);
	   stack.push(2);
	   stack.push(3);
	   
	   stack.showElement();
	   System.out.println("\nTop element: " + stack.top());
	   stack.showElement();
	   System.out.println("\nElement removed: " + stack.pop());
	   stack.showElement();
	   System.out.println("\nTop element: " + stack.top());
   } 
}
