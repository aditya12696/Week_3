package challengeproblem.filereadervsinputstreamreader;
import java.io.*;

public class FileReaderVsInputStreamReader {
    public static void main(String[] args) {
        String filePath = "F:\\Local\\Week03\\Day04\\src\\challengeproblem\\filereadervsinputstreamreader\\large_text_file.txt"; // Change to your actual file path

        // Measure time for FileReader
        long startTimeFR = System.nanoTime();
        int wordCountFR = countWordsUsingFileReader(filePath);
        long endTimeFR = System.nanoTime();
        System.out.println("FileReader - Word Count: " + wordCountFR);
        System.out.println("Time taken by FileReader: " + (endTimeFR - startTimeFR) / 1_000_000 + " ms");

        // Measure time for InputStreamReader
        long startTimeISR = System.nanoTime();
        int wordCountISR = countWordsUsingInputStreamReader(filePath);
        long endTimeISR = System.nanoTime();
        System.out.println("InputStreamReader - Word Count: " + wordCountISR);
        System.out.println("Time taken by InputStreamReader: " + (endTimeISR - startTimeISR) / 1_000_000 + " ms");
    }

    // Method to count words using FileReader
    private static int countWordsUsingFileReader(String filePath) {
        int wordCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.out.println("Error reading file with FileReader: " + e.getMessage());
        }
        return wordCount;
    }

    // Method to count words using InputStreamReader
    private static int countWordsUsingInputStreamReader(String filePath) {
        int wordCount = 0;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
        } catch (IOException e) {
            System.out.println("Error reading file with InputStreamReader: " + e.getMessage());
        }
        return wordCount;
    }
}
