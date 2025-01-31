package selectionsort;

public class SelectionSort {

    // Method to perform Selection Sort on the array
    public static void selectionSort(int[] scores) {
        int n = scores.length;

        // Traverse through all elements in the array
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the unsorted part of the array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first unsorted element
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    public static void main(String[] args) {
        // Array of unsorted exam scores
        int[] examScores = {85, 70, 90, 60, 95, 80};

        // Display scores before sorting
        System.out.println("Before sorting:");
        for (int score : examScores) {
            System.out.print(score + " ");
        }

        // Call the selectionSort method to sort the exam scores
        selectionSort(examScores);

        // Display scores after sorting
        System.out.println("\nAfter sorting:");
        for (int score : examScores) {
            System.out.print(score + " ");
        }
    }
}

