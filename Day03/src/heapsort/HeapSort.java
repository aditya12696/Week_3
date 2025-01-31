package heapsort;

public class HeapSort {

    // Method to perform Heap Sort on the array
    public static void heapSort(int[] salaries) {
        int n = salaries.length;

        // Build a Max Heap (rearrange the array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap the root (maximum value) with the last element
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;

            // Reheapify the reduced heap
            heapify(salaries, i, 0);
        }
    }

    // Method to maintain the heap property (Max Heap)
    private static void heapify(int[] salaries, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child

        // If left child is larger than root
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            // Swap salaries[i] and salaries[largest]
            int temp = salaries[i];
            salaries[i] = salaries[largest];
            salaries[largest] = temp;

            // Recursively heapify the affected subtree
            heapify(salaries, n, largest);
        }
    }

    public static void main(String[] args) {
        // Array of job applicants' expected salary demands
        int[] salaries = {60000, 90000, 45000, 120000, 80000, 55000, 100000};

        // Display salaries before sorting
        System.out.println("Before sorting:");
        for (int salary : salaries) {
            System.out.print(salary + " ");
        }

        // Call the heapSort method to sort the salaries
        heapSort(salaries);

        // Display salaries after sorting
        System.out.println("\nAfter sorting:");
        for (int salary : salaries) {
            System.out.print(salary + " ");
        }
    }
}
