package binarysearch.firstlastoccurrence;

public class FirstLastOccurrence {
    public static void main(String[] args) {
        int[] nums = {2, 4, 4, 4, 6, 9, 9}; // Sorted array
        int target = 4;

        int firstIndex = findFirstOccurrence(nums, target);
        int lastIndex = findLastOccurrence(nums, target);

        System.out.println("First Occurrence of " + target + ": " + firstIndex);
        System.out.println("Last Occurrence of " + target + ": " + lastIndex);
    }

    // Function to find the first occurrence of the target element
    public static int findFirstOccurrence(int[] nums, int target) {
        int left = 0, right = nums.length - 1, first = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                first = mid; // Store the first occurrence
                right = mid - 1; // Continue searching in the left half
            } else if (nums[mid] < target) {
                left = mid + 1; // Move right
            } else {
                right = mid - 1; // Move left
            }
        }
        return first;
    }

    // Function to find the last occurrence of the target element
    public static int findLastOccurrence(int[] nums, int target) {
        int left = 0, right = nums.length - 1, last = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                last = mid; // Store the last occurrence
                left = mid + 1; // Continue searching in the right half
            } else if (nums[mid] < target) {
                left = mid + 1; // Move right
            } else {
                right = mid - 1; // Move left
            }
        }
        return last;
    }
}
