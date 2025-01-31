package bubblesort;

public class BubbleSort {

    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;

        // Traverse through the array multiple times
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Compare adjacent elements and swap if needed
            for (int j = 0; j < n - 1 - i; j++) {
                if (marks[j] > marks[j + 1]) {
                    // Swap marks[j] and marks[j+1]
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no swaps were made, array is already sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] marks = {85, 92, 78, 90, 88, 76, 95};

        System.out.println("Before sorting:");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }

        bubbleSort(marks);

        System.out.println("\nAfter sorting:");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
    }
}
