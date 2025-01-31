package quicksort;

public class QuickSort {

    // Method to perform Quick Sort on the array
    public static void quickSort(int[] prices, int low, int high) {
        if (low < high) {
            // Find the pivot index after partitioning the array
            int pivotIndex = partition(prices, low, high);

            // Recursively sort the left and right partitions
            quickSort(prices, low, pivotIndex - 1);  // Left partition
            quickSort(prices, pivotIndex + 1, high); // Right partition
        }
    }

    // Partition the array into two parts around a pivot element
    private static int partition(int[] prices, int low, int high) {
        // Choosing the pivot element (we'll use the last element as the pivot)
        int pivot = prices[high];
        int i = low - 1; // Index of smaller element

        // Traverse through the array and rearrange elements around the pivot
        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (prices[j] <= pivot) {
                i++;
                // Swap prices[i] and prices[j]
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        // Swap the pivot element with the element at index i + 1
        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        // Return the index where the pivot element is placed
        return i + 1;
    }

    public static void main(String[] args) {
        // Array of unsorted product prices
        int[] productPrices = {250, 400, 100, 350, 600, 200};

        // Display product prices before sorting
        System.out.println("Before sorting:");
        for (int price : productPrices) {
            System.out.print(price + " ");
        }

        // Call the quickSort method to sort the product prices
        quickSort(productPrices, 0, productPrices.length - 1);

        // Display product prices after sorting
        System.out.println("\nAfter sorting:");
        for (int price : productPrices) {
            System.out.print(price + " ");
        }
    }
}

