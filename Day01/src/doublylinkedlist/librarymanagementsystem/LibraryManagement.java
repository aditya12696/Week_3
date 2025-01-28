package src.doublylinkedlist.librarymanagementsystem;

public class LibraryManagement {
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

        // Adding books to the library
        library.addAtBeginning("To Kill a Mockingbird", "Harper Lee", "Fiction", 101, true);
        library.addAtEnd("1984", "George Orwell", "Dystopian", 102, true);
        library.addAtPosition(2, "The Great Gatsby", "F. Scott Fitzgerald", "Classic", 103, true);

        // Display books in forward and reverse order
        library.displayForward();
        System.out.println();
        library.displayReverse();

        // Search for a book
        System.out.println();
        library.searchBook("1984");
        library.searchBook("George Orwell");

        // Update availability
        System.out.println();
        library.updateAvailability(103, false);

        // Remove a book
        System.out.println();
        library.removeByBookId(102);

        // Display books after removal
        System.out.println();
        library.displayForward();

        // Count total books
        System.out.println();
        System.out.println("Total Books in Library: " + library.countBooks());
    }
}
