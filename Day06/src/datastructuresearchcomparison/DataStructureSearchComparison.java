package datastructuresearchcomparison;
import java.util.*;

public class DataStructureSearchComparison {

    // Searching in an Array (O(N) - Linear Search)
    public static boolean searchInArray(int[] array, int target) {
        for (int num : array) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }

    // Searching in a HashSet (O(1) average case)
    public static boolean searchInHashSet(HashSet<Integer> hashSet, int target) {
        return hashSet.contains(target);
    }

    // Searching in a TreeSet (O(log N) - Binary Search in BST)
    public static boolean searchInTreeSet(TreeSet<Integer> treeSet, int target) {
        return treeSet.contains(target);
    }

    public static void main(String[] args) {
        int[] datasetSizes = {1000, 100000, 1000000}; // Different dataset sizes for comparison

        for (int size : datasetSizes) {
            // Generate random dataset
            int[] array = new int[size];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();
            Random random = new Random();

            for (int i = 0; i < size; i++) {
                int value = random.nextInt(size * 10); // Generate random numbers
                array[i] = value;
                hashSet.add(value);
                treeSet.add(value);
            }

            int target = array[random.nextInt(size)]; // Pick a random target to search

            // Measure Array Search time
            long startTime = System.nanoTime();
            boolean arrayResult = searchInArray(array, target);
            long arrayTime = System.nanoTime() - startTime;

            // Measure HashSet Search time
            startTime = System.nanoTime();
            boolean hashSetResult = searchInHashSet(hashSet, target);
            long hashSetTime = System.nanoTime() - startTime;

            // Measure TreeSet Search time
            startTime = System.nanoTime();
            boolean treeSetResult = searchInTreeSet(treeSet, target);
            long treeSetTime = System.nanoTime() - startTime;

            // Print results
            System.out.println("Dataset Size: " + size);
            System.out.println("Array Search Time (O(N)): " + arrayTime / 1_000_000.0 + " ms | Found: " + arrayResult);
            System.out.println("HashSet Search Time (O(1)): " + hashSetTime / 1_000_000.0 + " ms | Found: " + hashSetResult);
            System.out.println("TreeSet Search Time (O(log N)): " + treeSetTime / 1_000_000.0 + " ms | Found: " + treeSetResult);
            System.out.println("----------------------------------");
        }
    }
}
