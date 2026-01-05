package com.linkedlist.singlylinkedlist.socialmediafriendconnections;

public class UseSocialMedia{
    public static void main(String[] args) {

        SocialNetwork network = new SocialNetwork();

        network.addUser(1, "Akshay", 22);
        network.addUser(2, "Avinash", 22);
        network.addUser(3, "Deepanshu", 21);
        network.addUser(4, "Priyanshu", 23);

        network.addFriend(1, 2);
        network.addFriend(1, 3);
        network.addFriend(2, 3);
        network.addFriend(3, 4);

        network.displayFriends(1);

        System.out.println();
        network.findMutualFriends(1, 2);

        System.out.println();
        network.countFriends();

        System.out.println("\nAfter removing connection:");
        network.removeFriend(1, 3);
        network.displayFriends(1);
    }
}
