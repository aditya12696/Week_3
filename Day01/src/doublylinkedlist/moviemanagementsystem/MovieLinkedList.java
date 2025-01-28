package src.doublylinkedlist.moviemanagementsystem;

public class MovieLinkedList {
    private MovieNode head;
    private MovieNode tail;

    public MovieLinkedList() {
        head = null;
        tail = null;
    }

    public void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void addAtPosition(int position, String title, String director, int year, double rating) {
        if (position <= 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        MovieNode newNode = new MovieNode(title, director, year, rating);
        MovieNode current = head;
        int count = 1;

        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        if (current == null) {
            addAtEnd(title, director, year, rating);
        } else {
            newNode.next = current.next;
            if (current.next != null) {
                current.next.prev = newNode;
            }
            current.next = newNode;
            newNode.prev = current;

            if (newNode.next == null) {
                tail = newNode;
            }
        }
    }

    public void removeByTitle(String title) {
        MovieNode current = head;

        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                System.out.println("Movie '" + title + "' removed successfully.");
                return;
            }
            current = current.next;
        }
        System.out.println("Movie '" + title + "' not found.");
    }

    public void searchByDirector(String director) {
        MovieNode current = head;
        boolean found = false;

        while (current != null) {
            if (current.director.equalsIgnoreCase(director)) {
                System.out.println("Found Movie: " + current.title + " (" + current.year + "), Rating: " + current.rating);
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("No movies found by Director: " + director);
        }
    }

    public void searchByRating(double rating) {
        MovieNode current = head;
        boolean found = false;

        while (current != null) {
            if (current.rating == rating) {
                System.out.println("Found Movie: " + current.title + " by " + current.director + " (" + current.year + ")");
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("No movies found with Rating: " + rating);
        }
    }

    public void displayForward() {
        MovieNode current = head;

        System.out.println("Movies in Forward Order:");
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year: " + current.year + ", Rating: " + current.rating);
            current = current.next;
        }
    }

    public void displayReverse() {
        MovieNode current = tail;

        System.out.println("Movies in Reverse Order:");
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year: " + current.year + ", Rating: " + current.rating);
            current = current.prev;
        }
    }

    public void updateRating(String title, double newRating) {
        MovieNode current = head;

        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Rating updated for movie '" + title + "'. New Rating: " + newRating);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie '" + title + "' not found.");
    }
}
