package fibonaccicomparison;
public class FibonacciComparison {

    // Recursive Fibonacci (Exponential Time Complexity: O(2ⁿ))
    public static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci (Linear Time Complexity: O(N))
    public static int fibonacciIterative(int n) {
        if (n <= 1) {
            return n;
        }
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] fibonacciNumbers = {10, 30, 50}; // Test cases for comparison

        for (int n : fibonacciNumbers) {
            // Measure Recursive Fibonacci performance (Skip for large N)
            long recursiveTime = -1;
            if (n <= 30) { // Avoid excessive computation for large N
                long startTime = System.nanoTime();
                int recursiveResult = fibonacciRecursive(n);
                recursiveTime = System.nanoTime() - startTime;
                System.out.println("Recursive Fibonacci(" + n + ") = " + recursiveResult);
            } else {
                System.out.println("Recursive Fibonacci(" + n + "): Unfeasible for large values");
            }

            // Measure Iterative Fibonacci performance
            long startTime = System.nanoTime();
            int iterativeResult = fibonacciIterative(n);
            long iterativeTime = System.nanoTime() - startTime;

            // Print results
            System.out.println("Iterative Fibonacci(" + n + ") = " + iterativeResult);
            if (recursiveTime != -1) {
                System.out.println("Recursive Time: " + recursiveTime / 1_000_000.0 + " ms");
            }
            System.out.println("Iterative Time: " + iterativeTime / 1_000_000.0 + " ms");
            System.out.println("----------------------------------");
        }
    }
}
