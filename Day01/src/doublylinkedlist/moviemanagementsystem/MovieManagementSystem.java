package src.doublylinkedlist.moviemanagementsystem;

public class MovieManagementSystem{
    public static void main(String[] args) {
        MovieLinkedList movieList = new MovieLinkedList();

        // Adding movies
        movieList.addAtBeginning("Inception", "Christopher Nolan", 2010, 9.0);
        movieList.addAtEnd("The Godfather", "Francis Ford Coppola", 1972, 9.2);
        movieList.addAtPosition(2, "The Dark Knight", "Christopher Nolan", 2008, 9.1);

        // Display movies
        movieList.displayForward();
        System.out.println();
        movieList.displayReverse();

        // Search for movies
        System.out.println();
        movieList.searchByDirector("Christopher Nolan");
        System.out.println();
        movieList.searchByRating(9.2);

        // Update movie rating
        System.out.println();
        movieList.updateRating("Inception", 9.5);

        // Remove a movie
        System.out.println();
        movieList.removeByTitle("The Godfather");

        // Display movies again
        System.out.println();
        movieList.displayForward();
    }
}
