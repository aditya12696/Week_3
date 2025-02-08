package filereadingcomparison;
import java.io.*;

public class FileReadingComparison {

    // Reading using FileReader (Character Stream) - Reads character by character
    public static long readUsingFileReader(String filePath) throws IOException {
        long startTime = System.nanoTime();
        try (FileReader fileReader = new FileReader(filePath)) {
            while (fileReader.read() != -1) {
                // Read character by character
            }
        }
        return System.nanoTime() - startTime;
    }

    // Reading using InputStreamReader (Byte Stream) - Reads in byte chunks and converts to characters
    public static long readUsingInputStreamReader(String filePath) throws IOException {
        long startTime = System.nanoTime();
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath))) {
            while (inputStreamReader.read() != -1) {
                // Read character by character
            }
        }
        return System.nanoTime() - startTime;
    }

    public static void main(String[] args) {
        String filePath = "F:\\Local\\Week03\\Day06\\src\\filereadingcomparison\\100mb-examplefile-com.txt"; // Path to a large test file (500MB)

        try {
            // Measure FileReader performance
            long fileReaderTime = readUsingFileReader(filePath);

            // Measure InputStreamReader performance
            long inputStreamReaderTime = readUsingInputStreamReader(filePath);

            // Print results
            System.out.println("File Size: 500MB");
            System.out.println("FileReader Time: " + fileReaderTime / 1_000_000_000.0 + " sec");
            System.out.println("InputStreamReader Time: " + inputStreamReaderTime / 1_000_000_000.0 + " sec");
            System.out.println("----------------------------------");

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
