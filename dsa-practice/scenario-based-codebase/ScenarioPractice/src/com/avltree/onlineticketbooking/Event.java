package com.avltree.onlineticketbooking;

public class Event {
    int startTime;     
    String eventName;

    Event left, right;

    public Event(int startTime, String eventName) {
        this.startTime = startTime;
        this.eventName = eventName;
        left = right = null;
    }
}
