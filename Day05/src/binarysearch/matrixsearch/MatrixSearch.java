package binarysearch.matrixsearch;

public class MatrixSearch {
    public static void main(String[] args) {
        // Example 2D matrix where each row is sorted
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        int target = 16;
        boolean result = searchMatrix(matrix, target); // Search the target in the matrix

        // Print the result
        System.out.println("Target " + target + " found: " + result);
    }

    // Method to search a target in the 2D sorted matrix using Binary Search
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0, right = rows * cols - 1; // Treating the matrix as a 1D array

        while (left <= right) {
            int mid = left + (right - left) / 2; // Find the middle index

            // Convert the 1D mid index to 2D (row, col)
            int midElement = matrix[mid / cols][mid % cols];

            // Compare the mid element with the target
            if (midElement == target) {
                return true; // Target found
            } else if (midElement < target) {
                left = mid + 1; // Search the right half
            } else {
                right = mid - 1; // Search the left half
            }
        }

        return false; // Target not found
    }
}
