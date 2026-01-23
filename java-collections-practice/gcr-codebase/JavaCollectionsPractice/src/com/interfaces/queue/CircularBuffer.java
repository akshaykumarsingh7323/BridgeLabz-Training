package com.interfaces.queue;

public class CircularBuffer {
	private int size;
	private int rear;
	private int front;
	private int buffer[];
	private int count;
	
	CircularBuffer(int size) {
		this.size = size;
		int rear = 0;
		int front = 0;
		buffer = new int[size];
		count = 0;
	}
	
	void insert(int value) {
		buffer[rear] = value;
		rear = (rear + 1) % size;
		
		if(count == size) {
			front = (front + 1) % size;
		}else {
			count++;
		}
	}
	
	void display() {
		for(int i = 0; i < size; i++) {
			System.out.print(buffer[(front + i) % size] + " ");
		}
	    System.out.println();
	}
	
	public static void main(String[] args) {
		CircularBuffer cb = new CircularBuffer(3);
		
		cb.insert(1);
		cb.insert(2);
		cb.display();
		cb.insert(3);
		cb.insert(4);
		cb.display();
	}
}
