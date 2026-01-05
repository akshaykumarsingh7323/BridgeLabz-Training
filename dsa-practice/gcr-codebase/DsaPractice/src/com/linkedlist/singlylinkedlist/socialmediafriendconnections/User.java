package com.linkedlist.singlylinkedlist.socialmediafriendconnections;

class User {
    int userId;
    String name;
    int age;

    FriendNode friendHead; 
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendHead = null;
        this.next = null;
    }
}
