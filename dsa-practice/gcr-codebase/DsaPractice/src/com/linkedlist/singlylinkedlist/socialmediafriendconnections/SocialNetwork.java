package com.linkedlist.singlylinkedlist.socialmediafriendconnections;

class SocialNetwork {
    private User head;


    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        newUser.next = head;
        head = newUser;
    }


    public User searchById(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    public User searchByName(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name))
                return temp;
            temp = temp.next;
        }
        return null;
    }


    public void addFriend(int userId1, int userId2) {
        User u1 = searchById(userId1);
        User u2 = searchById(userId2);

        if (u1 == null || u2 == null || userId1 == userId2)
            return;

        addFriendToList(u1, userId2);
        addFriendToList(u2, userId1);
    }

    private void addFriendToList(User user, int friendId) {
        FriendNode temp = user.friendHead;
        while (temp != null) {
            if (temp.friendId == friendId)
                return; // Already friends
            temp = temp.next;
        }

        FriendNode newFriend = new FriendNode(friendId);
        newFriend.next = user.friendHead;
        user.friendHead = newFriend;
    }


    public void removeFriend(int userId1, int userId2) {
        User u1 = searchById(userId1);
        User u2 = searchById(userId2);

        if (u1 == null || u2 == null)
            return;

        removeFriendFromList(u1, userId2);
        removeFriendFromList(u2, userId1);
    }

    private void removeFriendFromList(User user, int friendId) {
        FriendNode temp = user.friendHead, prev = null;

        while (temp != null) {
            if (temp.friendId == friendId) {
                if (prev == null)
                    user.friendHead = temp.next;
                else
                    prev.next = temp.next;
                return;
            }
            prev = temp;
            temp = temp.next;
        }
    }


    public void displayFriends(int userId) {
        User user = searchById(userId);
        if (user == null) return;

        System.out.println("Friends of " + user.name + ":");
        FriendNode temp = user.friendHead;

        if (temp == null) {
            System.out.println("No friends.");
            return;
        }

        while (temp != null) {
            User friend = searchById(temp.friendId);
            if (friend != null)
                System.out.println(friend.userId + " - " + friend.name);
            temp = temp.next;
        }
    }


    public void findMutualFriends(int userId1, int userId2) {
        User u1 = searchById(userId1);
        User u2 = searchById(userId2);

        if (u1 == null || u2 == null)
            return;

        System.out.println("Mutual Friends:");

        FriendNode f1 = u1.friendHead;
        while (f1 != null) {
            FriendNode f2 = u2.friendHead;
            while (f2 != null) {
                if (f1.friendId == f2.friendId) {
                    User mutual = searchById(f1.friendId);
                    if (mutual != null)
                        System.out.println(mutual.userId + " - " + mutual.name);
                }
                f2 = f2.next;
            }
            f1 = f1.next;
        }
    }


    public void countFriends() {
        User temp = head;
        while (temp != null) {
            int count = 0;
            FriendNode f = temp.friendHead;
            while (f != null) {
                count++;
                f = f.next;
            }
            System.out.println(temp.name + " has " + count + " friends.");
            temp = temp.next;
        }
    }
}
