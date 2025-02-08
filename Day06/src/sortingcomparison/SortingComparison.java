package sortingcomparison;
import java.util.Arrays;
import java.util.Random;

public class SortingComparison {

    // Perform Bubble Sort - O(N^2)
    public static void bubbleSort(int[] data) {
        int n = data.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    // Swap elements
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no elements were swapped, array is sorted
            if (!swapped) break;
        }
    }

    // Perform Merge Sort - O(N log N)
    public static void mergeSort(int[] data, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Recursively divide the array
            mergeSort(data, left, mid);
            mergeSort(data, mid + 1, right);

            // Merge the sorted halves
            merge(data, left, mid, right);
        }
    }

    private static void merge(int[] data, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data
        System.arraycopy(data, left, leftArray, 0, n1);
        System.arraycopy(data, mid + 1, rightArray, 0, n2);

        // Merge the arrays
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                data[k++] = leftArray[i++];
            } else {
                data[k++] = rightArray[j++];
            }
        }

        // Copy remaining elements
        while (i < n1) {
            data[k++] = leftArray[i++];
        }
        while (j < n2) {
            data[k++] = rightArray[j++];
        }
    }

    // Perform Quick Sort - O(N log N)
    public static void quickSort(int[] data, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(data, low, high);

            // Recursively sort elements before and after partition
            quickSort(data, low, pivotIndex - 1);
            quickSort(data, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] data, int low, int high) {
        int pivot = data[high]; // Choose pivot as the last element
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (data[j] < pivot) {
                i++;
                // Swap elements
                int temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }

        // Swap pivot into correct position
        int temp = data[i + 1];
        data[i + 1] = data[high];
        data[high] = temp;

        return i + 1;
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

            // Copy the dataset for each sorting algorithm
            int[] bubbleData = Arrays.copyOf(data, data.length);
            int[] mergeData = Arrays.copyOf(data, data.length);
            int[] quickData = Arrays.copyOf(data, data.length);

            // Measure Bubble Sort time (skip for large datasets)
            long bubbleSortTime = -1;
            if (size <= 10000) {
                long startTime = System.nanoTime();
                bubbleSort(bubbleData);
                bubbleSortTime = System.nanoTime() - startTime;
            }

            // Measure Merge Sort time
            long startTime = System.nanoTime();
            mergeSort(mergeData, 0, mergeData.length - 1);
            long mergeSortTime = System.nanoTime() - startTime;

            // Measure Quick Sort time
            startTime = System.nanoTime();
            quickSort(quickData, 0, quickData.length - 1);
            long quickSortTime = System.nanoTime() - startTime;

            // Print results
            System.out.println("Dataset Size: " + size);
            if (bubbleSortTime != -1) {
                System.out.println("Bubble Sort Time: " + bubbleSortTime / 1_000_000.0 + " ms");
            } else {
                System.out.println("Bubble Sort: Unfeasible for large datasets");
            }
            System.out.println("Merge Sort Time: " + mergeSortTime / 1_000_000.0 + " ms");
            System.out.println("Quick Sort Time: " + quickSortTime / 1_000_000.0 + " ms");
            System.out.println("----------------------------------");
        }
    }
}
