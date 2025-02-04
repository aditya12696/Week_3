package challengeproblem.missingpositiveandbinarysearch;
import java.util.HashSet;

public class MissingPositiveHashing {
    // Function to find the first missing positive integer using HashSet
    public static int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        // Add all positive numbers to the HashSet
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }

        // Check for the first missing positive number starting from 1
        int missingNumber = 1;
        while (set.contains(missingNumber)) {
            missingNumber++; // Keep increasing until we find a missing number
        }

        return missingNumber; // The first missing positive integer
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1}; // Example input array
        int missing = firstMissingPositive(nums);
        System.out.println("First Missing Positive: " + missing); // Expected output: 2
    }
}
