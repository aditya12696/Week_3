package hashmapshashfunctions.twosum;
import java.util.HashMap;

public class TwoSum {

    public static int[] findTwoSum(int[] nums, int target) {
        // Create a hash map to store the numbers and their indices
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if the complement of the current number exists in the map
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};  // Return the indices
            }

            // If not, store the current number and its index in the map
            map.put(nums[i], i);
        }

        // If no solution is found, return an empty array (or you can return null)
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = findTwoSum(nums, target);

        if (result.length == 0) {
            System.out.println("No solution found");
        } else {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        }
    }
}
