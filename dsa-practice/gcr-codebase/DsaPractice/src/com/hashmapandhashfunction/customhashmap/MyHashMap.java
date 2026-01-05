package com.hashmapandhashfunction.customhashmap;

import java.util.Scanner;

class MyHashMap {

    static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private int SIZE = 10;
    private Node[] buckets;

    MyHashMap() {
        buckets = new Node[SIZE];
    }

    private int getIndex(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = getIndex(key);
        Node head = buckets[index];

        Node current = head;
        while (current != null) {
            if (current.key == key) {
                current.value = value; 
                return;
            }
            current = current.next;
        }

        Node newNode = new Node(key, value);
        newNode.next = head;
        buckets[index] = newNode;
    }

    public Integer get(int key) {
        int index = getIndex(key);
        Node current = buckets[index];

        while (current != null) {
            if (current.key == key)
                return current.value;
            current = current.next;
        }
        return null;
    }

    public void remove(int key) {
        int index = getIndex(key);
        Node current = buckets[index];
        Node prev = null;

        while (current != null) {
            if (current.key == key) {
                if (prev == null)
                    buckets[index] = current.next;
                else
                    prev.next = current.next;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public void display() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print("Bucket " + i + ": ");
            Node curr = buckets[i];
            while (curr != null) {
                System.out.print("[" + curr.key + "=" + curr.value + "] -> ");
                curr = curr.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MyHashMap map = new MyHashMap();

        while (true) {
            System.out.println("\n1. Put");
            System.out.println("2. Get");
            System.out.println("3. Remove");
            System.out.println("4. Display");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter key: ");
                    int key = sc.nextInt();
                    System.out.print("Enter value: ");
                    int value = sc.nextInt();
                    map.put(key, value);
                    break;

                case 2:
                    System.out.print("Enter key: ");
                    key = sc.nextInt();
                    Integer result = map.get(key);
                    System.out.println(result != null ? "Value: " + result : "Key not found");
                    break;

                case 3:
                    System.out.print("Enter key: ");
                    key = sc.nextInt();
                    map.remove(key);
                    System.out.println("Key removed if existed.");
                    break;

                case 4:
                    map.display();
                    break;

                case 5:
                    System.exit(0);
            }
        }
    }
}
