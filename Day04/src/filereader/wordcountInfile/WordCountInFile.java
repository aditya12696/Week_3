package filereader.wordcountInfile;
import java.io.*;

public class WordCountInFile {
    public static void main(String[] args) {
        String filePath = "F:\\\\Local\\\\Week03\\\\Day04\\\\src\\\\filereader\\\\wordcountInfile\\\\example.txt"; // Change this to your file path
        String targetWord = "hello"; // Change this to the word you want to count
        int wordCount = 0;

        try {
            // Create a FileReader to read the file
            FileReader fileReader = new FileReader(filePath);
            // Wrap it with BufferedReader for efficient reading
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            // Read each line from the file
            while ((line = bufferedReader.readLine()) != null) {
                // Convert line to lowercase and split it into words
                String[] words = line.toLowerCase().split("\\s+");

                // Count occurrences of the target word
                for (String word : words) {
                    if (word.equals(targetWord.toLowerCase())) {
                        wordCount++;
                    }
                }
            }

            // Close the file resources
            bufferedReader.close();
            fileReader.close();

            // Print the final count
            System.out.println("The word \"" + targetWord + "\" appears " + wordCount + " times in the file.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
