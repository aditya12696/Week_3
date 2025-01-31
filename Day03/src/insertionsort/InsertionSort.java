package insertionsort;

public class InsertionSort {

    // Method to perform Insertion Sort on the array
    public static void insertionSort(int[] employeeIds) {
        int n = employeeIds.length;

        // Traverse through the unsorted part of the array
        for (int i = 1; i < n; i++) {
            int key = employeeIds[i];  // The element to be inserted
            int j = i - 1;

            // Move elements of employeeIds[0..i-1] that are greater than 'key'
            // to one position ahead of their current position
            while (j >= 0 && employeeIds[j] > key) {
                employeeIds[j + 1] = employeeIds[j];
                j = j - 1;
            }

            // Place the key element at the correct position
            employeeIds[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        // Array of unsorted employee IDs
        int[] employeeIds = {102, 305, 204, 103, 301, 305};

        // Display employee IDs before sorting
        System.out.println("Before sorting:");
        for (int id : employeeIds) {
            System.out.print(id + " ");
        }

        // Call the insertionSort method to sort the employee IDs
        insertionSort(employeeIds);

        // Display employee IDs after sorting
        System.out.println("\nAfter sorting:");
        for (int id : employeeIds) {
            System.out.print(id + " ");
        }
    }
}

