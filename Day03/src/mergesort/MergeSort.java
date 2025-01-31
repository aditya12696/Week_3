package mergesort;

public class MergeSort {

    // Method to perform Merge Sort on the array
    public static void mergeSort(int[] prices) {
        if (prices.length <= 1) {
            return;  // Base case: array is already sorted if it has 1 or fewer elements
        }

        // Divide the array into two halves
        int mid = prices.length / 2;
        int[] left = new int[mid];
        int[] right = new int[prices.length - mid];

        // Copy data to left and right arrays
        System.arraycopy(prices, 0, left, 0, mid);
        System.arraycopy(prices, mid, right, 0, prices.length - mid);

        // Recursively sort both halves
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted halves
        merge(prices, left, right);
    }

    // Method to merge two sorted arrays into a single sorted array
    private static void merge(int[] prices, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Compare elements of left and right arrays and merge them in sorted order
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                prices[k++] = left[i++];
            } else {
                prices[k++] = right[j++];
            }
        }

        // Copy remaining elements of left array, if any
        while (i < left.length) {
            prices[k++] = left[i++];
        }

        // Copy remaining elements of right array, if any
        while (j < right.length) {
            prices[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        // Array of unsorted book prices
        int[] bookPrices = {350, 200, 450, 150, 600, 275};

        // Display book prices before sorting
        System.out.println("Before sorting:");
        for (int price : bookPrices) {
            System.out.print(price + " ");
        }

        // Call the mergeSort method to sort the book prices
        mergeSort(bookPrices);

        // Display book prices after sorting
        System.out.println("\nAfter sorting:");
        for (int price : bookPrices) {
            System.out.print(price + " ");
        }
    }
}

