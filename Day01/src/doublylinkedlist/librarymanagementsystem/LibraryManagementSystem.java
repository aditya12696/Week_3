package src.doublylinkedlist.librarymanagementsystem;

public class LibraryManagementSystem {
    private BookNode head;
    private BookNode tail;

    public LibraryManagementSystem() {
        head = null;
        tail = null;
    }

    // Add book at the beginning
    public void addAtBeginning(String bookTitle, String author, String genre, int bookId, boolean isAvailable) {
        BookNode newNode = new BookNode(bookTitle, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add book at the end
    public void addAtEnd(String bookTitle, String author, String genre, int bookId, boolean isAvailable) {
        BookNode newNode = new BookNode(bookTitle, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Add book at a specific position
    public void addAtPosition(int position, String bookTitle, String author, String genre, int bookId, boolean isAvailable) {
        if (position <= 1 || head == null) {
            addAtBeginning(bookTitle, author, genre, bookId, isAvailable);
            return;
        }

        BookNode newNode = new BookNode(bookTitle, author, genre, bookId, isAvailable);
        BookNode current = head;
        int count = 1;

        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        if (current == null || current.next == null) {
            addAtEnd(bookTitle, author, genre, bookId, isAvailable);
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
    }

    // Remove book by Book ID
    public void removeByBookId(int bookId) {
        if (head == null) {
            System.out.println("No books in the library.");
            return;
        }

        if (head.bookId == bookId) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            System.out.println("Book with ID " + bookId + " removed successfully.");
            return;
        }

        BookNode current = head;
        while (current != null && current.bookId != bookId) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Book with ID " + bookId + " not found.");
        } else {
            if (current == tail) {
                tail = tail.prev;
                tail.next = null;
            } else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            System.out.println("Book with ID " + bookId + " removed successfully.");
        }
    }

    // Search book by Title or Author
    public void searchBook(String searchTerm) {
        BookNode current = head;
        boolean found = false;

        while (current != null) {
            if (current.bookTitle.equalsIgnoreCase(searchTerm) || current.author.equalsIgnoreCase(searchTerm)) {
                System.out.println("Found Book: Title=" + current.bookTitle + ", Author=" + current.author + ", Genre=" + current.genre + ", ID=" + current.bookId + ", Available=" + current.isAvailable);
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("No books found with the search term: " + searchTerm);
        }
    }

    // Update book availability
    public void updateAvailability(int bookId, boolean isAvailable) {
        BookNode current = head;

        while (current != null) {
            if (current.bookId == bookId) {
                current.isAvailable = isAvailable;
                System.out.println("Availability updated for Book ID " + bookId);
                return;
            }
            current = current.next;
        }

        System.out.println("Book with ID " + bookId + " not found.");
    }

    // Display books in forward order
    public void displayForward() {
        if (head == null) {
            System.out.println("No books in the library.");
            return;
        }

        System.out.println("Books in Library (Forward Order):");
        BookNode current = head;
        while (current != null) {
            System.out.println("Title=" + current.bookTitle + ", Author=" + current.author + ", Genre=" + current.genre + ", ID=" + current.bookId + ", Available=" + current.isAvailable);
            current = current.next;
        }
    }

    // Display books in reverse order
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No books in the library.");
            return;
        }

        System.out.println("Books in Library (Reverse Order):");
        BookNode current = tail;
        while (current != null) {
            System.out.println("Title=" + current.bookTitle + ", Author=" + current.author + ", Genre=" + current.genre + ", ID=" + current.bookId + ", Available=" + current.isAvailable);
            current = current.prev;
        }
    }

    // Count total number of books
    public int countBooks() {
        int count = 0;
        BookNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}
