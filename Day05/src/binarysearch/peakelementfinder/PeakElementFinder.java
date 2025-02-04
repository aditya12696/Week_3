package binarysearch.peakelementfinder;

public class PeakElementFinder {
    public static void main(String[] args) {
        // Example array with multiple peaks
        int[] arr = {1, 3, 20, 4, 1, 0, 5, 10, 7};

        int peakIndex = findPeakElement(arr); // Find the peak index

        // Print the peak element
        System.out.println("Peak Element Index: " + peakIndex);
        System.out.println("Peak Element: " + arr[peakIndex]);
    }

    // Method to find a peak element using Binary Search
    public static int findPeakElement(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2; // Find mid index

            // If mid element is greater than the next element, peak is in the left half
            if (arr[mid] > arr[mid + 1]) {
                right = mid; // Move to the left part
            }
            // Otherwise, peak is in the right half
            else {
                left = mid + 1; // Move to the right part
            }
        }
        return left; // Left points to the peak element
    }
}
