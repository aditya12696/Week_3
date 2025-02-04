package binarysearch.findrotationpoint;

public class FindRotationPoint {
    public static void main(String[] args) {
        // Example rotated sorted array
        int[] arr = { 7, 8, 9, 1, 2, 3, 4, 5, 6 };

        int rotationPointIndex = findRotationPoint(arr); // Call the binary search method

        // Print the index of the smallest element
        System.out.println("Rotation Point Index: " + rotationPointIndex);
        System.out.println("Smallest Element: " + arr[rotationPointIndex]);
    }

    // Method to find the index of the smallest element (rotation point)
    public static int findRotationPoint(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) { // Perform binary search
            int mid = left + (right - left) / 2; // Find mid element

            // If mid element is greater than the last element, search in the right half
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            }
            // Otherwise, the smallest element might be in the left half
            else {
                right = mid;
            }
        }
        return left; // Left points to the smallest element
    }
}
