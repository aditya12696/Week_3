package countingsort;

public class CountingSort {

    public static void countingSort(int[] ages) {
        int[] count = new int[9]; // Since ages range from 10 to 18

        // Step 1: Count the frequency of each age
        for (int age : ages) {
            count[age - 10]++;
        }

        // Step 2: Rebuild the sorted array
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                ages[index++] = i + 10;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        // Sample array of student ages
        int[] ages = {16, 14, 15, 17, 10, 18, 15, 12, 13, 16};

        // Print ages before sorting
        System.out.println("Before sorting:");
        for (int age : ages) {
            System.out.print(age + " ");
        }

        // Sort the ages
        countingSort(ages);

        // Print ages after sorting
        System.out.println("\nAfter sorting:");
        for (int age : ages) {
            System.out.print(age + " ");
        }
    }
}

