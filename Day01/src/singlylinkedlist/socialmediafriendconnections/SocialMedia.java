package src.singlylinkedlist.socialmediafriendconnections;

public class SocialMedia {
    public static void main(String[] args) {
        SocialMediaManager manager = new SocialMediaManager();

        // Adding users
        manager.addUser(1, "Adi", 25);
        manager.addUser(2, "Bo", 30);
        manager.addUser(3, "Charlie", 22);
        manager.addUser(4, "Diana", 28);

        // Adding friend connections
        manager.addFriendConnection(1, 2);
        manager.addFriendConnection(1, 3);
        manager.addFriendConnection(2, 4);

        // Display friends of a user
        manager.displayAllFriends(1);
        manager.displayAllFriends(2);

        // Find mutual friends
        manager.findMutualFriends(1, 2);

        // Remove a friend connection
        manager.removeFriendConnection(1, 2);

        // Display friends after removal
        manager.displayAllFriends(1);
        manager.displayAllFriends(2);

        // Count friends for each user
        manager.countFriendsForEachUser();
    }
}
