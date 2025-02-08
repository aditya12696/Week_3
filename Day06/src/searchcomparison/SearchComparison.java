package searchcomparison;
import java.util.Arrays;
import java.util.Random;

public class SearchComparison {

    // Perform Linear Search - O(N)
    public static int linearSearch(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i; // Target found
            }
        }
        return -1; // Target not found
    }

    // Perform Binary Search - O(log N)
    public static int binarySearch(int[] data, int target) {
        int left = 0, right = data.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (data[mid] == target) {
                return mid; // Target found
            } else if (data[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] datasetSizes = {1000, 10000, 1000000}; // Different dataset sizes
        Random random = new Random();

        for (int size : datasetSizes) {
            int[] data = new int[size];

            // Generate random dataset
            for (int i = 0; i < size; i++) {
                data[i] = random.nextInt(size);
            }

            int target = data[random.nextInt(size)]; // Random target to search

            // Measure Linear Search time
            long startTime = System.nanoTime();
            linearSearch(data, target);
            long linearSearchTime = System.nanoTime() - startTime;

            // Sort data for Binary Search
            Arrays.sort(data);

            // Measure Binary Search time
            startTime = System.nanoTime();
            binarySearch(data, target);
            long binarySearchTime = System.nanoTime() - startTime;

            // Print results
            System.out.println("Dataset Size: " + size);
            System.out.println("Linear Search Time: " + linearSearchTime / 1_000_000.0 + " ms");
            System.out.println("Binary Search Time: " + binarySearchTime / 1_000_000.0 + " ms");
            System.out.println("----------------------------------");
        }
    }
}
