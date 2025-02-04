package linearsearch.firstnegativenumber;

public class FirstNegativeNumber {
    public static void main(String[] args) {
        int[] numbers = {3, 7, 2, -5, 8, -10, 6}; // Example array

        int index = findFirstNegative(numbers); // Call the search method

        // Print the result based on the index found
        if (index != -1) {
            System.out.println("First negative number found at index: " + index);
        } else {
            System.out.println("No negative number found in the array.");
        }
    }

    // Method to find the first negative number in the array
    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) { // Iterate through the array
            if (arr[i] < 0) { // Check if the current element is negative
                return i; // Return the index of the first negative number
            }
        }
        return -1; // Return -1 if no negative number is found
    }
}

