package hashmapshashfunctions.zerosumsubarrays;
import java.util.*;

class ZeroSumSubarrays {

    static void findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;

        // Store sum = 0 at index -1 to handle cases where prefix itself forms a zero sum subarray
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // If sum is seen before, it means a subarray with zero sum exists
            if (map.containsKey(sum)) {
                for (int start : map.get(sum)) {
                    System.out.println("Subarray found: " + (start + 1) + " to " + i);
                }
            }

            // Add current sum to the map
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, -3, 1, 6, -3, -3};

        System.out.println("Zero Sum Subarrays:");
        findZeroSumSubarrays(arr);
    }
}
