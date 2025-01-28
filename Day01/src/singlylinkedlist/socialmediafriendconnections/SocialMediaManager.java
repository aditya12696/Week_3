package src.singlylinkedlist.socialmediafriendconnections;

public class SocialMediaManager {
        private UserNode head;

        public SocialMediaManager() {
                this.head = null;
        }

        // Add a new user
        public void addUser(int userId, String name, int age) {
                UserNode newUser = new UserNode(userId, name, age);
                if (head == null) {
                        head = newUser;
                } else {
                        UserNode current = head;
                        while (current.next != null) {
                                current = current.next;
                        }
                        current.next = newUser;
                }
        }

        // Find a user by User ID
        public UserNode findUserById(int userId) {
                UserNode current = head;
                while (current != null) {
                        if (current.userId == userId) {
                                return current;
                        }
                        current = current.next;
                }
                return null;
        }

        // Search for a user by Name
        public UserNode findUserByName(String name) {
                UserNode current = head;
                while (current != null) {
                        if (current.name.equalsIgnoreCase(name)) {
                                return current;
                        }
                        current = current.next;
                }
                return null;
        }

        // Add a friend connection between two users
        public void addFriendConnection(int userId1, int userId2) {
                UserNode user1 = findUserById(userId1);
                UserNode user2 = findUserById(userId2);

                if (user1 == null || user2 == null) {
                        System.out.println("One or both users not found.");
                        return;
                }

                user1.addFriend(userId2);
                user2.addFriend(userId1);
                System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
        }

        // Remove a friend connection
        public void removeFriendConnection(int userId1, int userId2) {
                UserNode user1 = findUserById(userId1);
                UserNode user2 = findUserById(userId2);

                if (user1 == null || user2 == null) {
                        System.out.println("One or both users not found.");
                        return;
                }

                user1.removeFriend(userId2);
                user2.removeFriend(userId1);
                System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
        }

        // Find mutual friends between two users
        public void findMutualFriends(int userId1, int userId2) {
                UserNode user1 = findUserById(userId1);
                UserNode user2 = findUserById(userId2);

                if (user1 == null || user2 == null) {
                        System.out.println("One or both users not found.");
                        return;
                }

                System.out.print("Mutual friends of " + user1.name + " and " + user2.name + ": ");
                FriendNode friend1 = user1.friends;

                while (friend1 != null) {
                        FriendNode friend2 = user2.friends;
                        while (friend2 != null) {
                                if (friend1.friendId == friend2.friendId) {
                                        System.out.print(friend1.friendId + " ");
                                }
                                friend2 = friend2.next;
                        }
                        friend1 = friend1.next;
                }
                System.out.println();
        }

        // Display all friends of a specific user
        public void displayAllFriends(int userId) {
                UserNode user = findUserById(userId);
                if (user != null) {
                        user.displayFriends();
                } else {
                        System.out.println("User not found.");
                }
        }

        // Count the number of friends for each user
        public void countFriendsForEachUser() {
                UserNode current = head;
                while (current != null) {
                        System.out.println(current.name + " has " + current.countFriends() + " friend(s).");
                        current = current.next;
                }
        }
}
