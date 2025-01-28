package src.singlylinkedlist.socialmediafriendconnections;

class UserNode {
    int userId;
    String name;
    int age;
    FriendNode friends; // Head of the friend list
    UserNode next;

    public UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friends = null;
        this.next = null;
    }

    public void addFriend(int friendId) {
        FriendNode newFriend = new FriendNode(friendId);
        if (friends == null) {
            friends = newFriend;
        } else {
            FriendNode current = friends;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newFriend;
        }
    }

    public void removeFriend(int friendId) {
        if (friends == null) return;

        if (friends.friendId == friendId) {
            friends = friends.next;
            return;
        }

        FriendNode current = friends;
        while (current.next != null && current.next.friendId != friendId) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public void displayFriends() {
        System.out.print("Friends of " + name + ": ");
        FriendNode current = friends;
        if (current == null) {
            System.out.println("No friends.");
            return;
        }
        while (current != null) {
            System.out.print(current.friendId + " ");
            current = current.next;
        }
        System.out.println();
    }

    public int countFriends() {
        int count = 0;
        FriendNode current = friends;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}
