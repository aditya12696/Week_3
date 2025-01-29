package hashmapshashfunctions.pairwithgivensum;
import java.util.*;

class PairWithGivenSum {

    static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;

            if (set.contains(complement)) {
                System.out.println("Pair found: (" + complement + ", " + num + ")");
                return true;
            }

            set.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7};
        int target = 17;

        if (!hasPairWithSum(arr, target)) {
            System.out.println("No pair found.");
        }
    }
}
