package challengeproblem.stringbuildervsstringbuffer;

public class StringBuilderVsStringBuffer {
    public static void main(String[] args) {
        int iterations = 1_000_000; // 1 million iterations
        String text = "hello"; // Sample string

        // Measure time for StringBuilder
        long startTimeSB = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long endTimeSB = System.nanoTime();
        System.out.println("Time taken by StringBuilder: " + (endTimeSB - startTimeSB) / 1_000_000 + " ms");

        // Measure time for StringBuffer
        long startTimeSBuf = System.nanoTime();
        StringBuffer sBuf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sBuf.append(text);
        }
        long endTimeSBuf = System.nanoTime();
        System.out.println("Time taken by StringBuffer: " + (endTimeSBuf - startTimeSBuf) / 1_000_000 + " ms");
    }
}
