package com.trafficmanager;

import java.util.LinkedList;
import java.util.Queue;

class TrafficManager {

    private VehicleNode head = null;
    private VehicleNode tail = null;
    private int roundaboutSize = 0;
    private final int MAX_CAPACITY = 4;

    private Queue<String> waitingQueue = new LinkedList<>();

    public void addVehicle(String vehicleNo) {

        if (roundaboutSize < MAX_CAPACITY) {
            VehicleNode newNode = new VehicleNode(vehicleNo);

            if (head == null) {
                head = tail = newNode;
                tail.next = head;
            } else {
                tail.next = newNode;
                tail = newNode;
                tail.next = head;
            }
            roundaboutSize++;
            System.out.println(vehicleNo + " entered roundabout");
        } else {
            waitingQueue.offer(vehicleNo);
            System.out.println("Roundabout full. " + vehicleNo + " added to waiting queue");
        }
    }

    public void removeVehicle(String vehicleNo) {

        if (head == null) {
            System.out.println("Roundabout empty");
            return;
        }

        VehicleNode curr = head;
        VehicleNode prev = tail;

        do {
            if (curr.vehicleNo.equals(vehicleNo)) {

                if (curr == head && curr == tail) {
                    head = tail = null;
                } else {
                    prev.next = curr.next;
                    if (curr == head)
                        head = curr.next;
                    if (curr == tail)
                        tail = prev;
                }

                roundaboutSize--;
                System.out.println(vehicleNo + " exited roundabout");

                if (!waitingQueue.isEmpty()) {
                    addVehicle(waitingQueue.poll());
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println("Vehicle not found");
    }

    public void displayRoundabout() {

        if (head == null) {
            System.out.println("Roundabout empty");
            return;
        }

        VehicleNode temp = head;
        System.out.print("Roundabout: ");

        do {
            System.out.print(temp.vehicleNo + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(Back to Start)");
    }

    public void displayQueue() {

        if (waitingQueue.isEmpty()) {
            System.out.println("Waiting queue empty");
            return;
        }
        System.out.println("Waiting Queue: " + waitingQueue);
    }
}

