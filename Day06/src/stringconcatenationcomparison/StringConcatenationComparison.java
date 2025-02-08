package stringconcatenationcomparison;
public class StringConcatenationComparison {

    // Concatenation using String (O(N²))
    public static long concatenateUsingString(int operations) {
        long startTime = System.nanoTime();
        String result = "";
        for (int i = 0; i < operations; i++) {
            result += "a"; // Creates a new object each time
        }
        return System.nanoTime() - startTime;
    }

    // Concatenation using StringBuilder (O(N))
    public static long concatenateUsingStringBuilder(int operations) {
        long startTime = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < operations; i++) {
            stringBuilder.append("a");
        }
        return System.nanoTime() - startTime;
    }

    // Concatenation using StringBuffer (O(N))
    public static long concatenateUsingStringBuffer(int operations) {
        long startTime = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < operations; i++) {
            stringBuffer.append("a");
        }
        return System.nanoTime() - startTime;
    }

    public static void main(String[] args) {
        int[] operationsCount = {1000, 10000, 1000000}; // Different operation sizes

        for (int operations : operationsCount) {
            // Measure String performance (skip for large values)
            long stringTime = -1;
            if (operations <= 10000) {
                stringTime = concatenateUsingString(operations);
            }

            // Measure StringBuilder performance
            long stringBuilderTime = concatenateUsingStringBuilder(operations);

            // Measure StringBuffer performance
            long stringBufferTime = concatenateUsingStringBuffer(operations);

            // Print results
            System.out.println("Operations Count: " + operations);
            if (stringTime != -1) {
                System.out.println("String Concatenation Time: " + stringTime / 1_000_000.0 + " ms");
            } else {
                System.out.println("String Concatenation: Unfeasible for large operations");
            }
            System.out.println("StringBuilder Concatenation Time: " + stringBuilderTime / 1_000_000.0 + " ms");
            System.out.println("StringBuffer Concatenation Time: " + stringBufferTime / 1_000_000.0 + " ms");
            System.out.println("----------------------------------");
        }
    }
}
