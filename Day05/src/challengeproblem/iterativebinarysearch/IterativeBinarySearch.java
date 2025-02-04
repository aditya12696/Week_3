package challengeproblem.iterativebinarysearch;
import java.util.Arrays;

public class IterativeBinarySearch {
    // Function to perform Binary Search iteratively
    public static int binarySearch(int[] nums, int target) {
        Arrays.sort(nums); // Sorting the array (Binary Search requires a sorted array)
        int left = 0, right = nums.length - 1;

        // Iteratively narrow down the search space
        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate the middle index

            if (nums[mid] == target) {
                return mid; // Target found, return the index
            } else if (nums[mid] < target) {
                left = mid + 1; // If target is larger, search in the right half
            } else {
                right = mid - 1; // If target is smaller, search in the left half
            }
        }

        return -1; // If the element is not found, return -1
    }

    public static void main(String[] args) {
        int[] nums = {10, 2, 30, 5, 8}; // Example input array
        int target = 5;

        int index = binarySearch(nums, target);
        System.out.println("Index of " + target + ": " + index); // Output: Index after sorting
    }
}
