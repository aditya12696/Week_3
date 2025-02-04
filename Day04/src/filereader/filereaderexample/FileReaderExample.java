package filereader.filereaderexample;
import java.io.*;

public class FileReaderExample {
    public static void main(String[] args) {
        String filePath = "F:\\Local\\Week03\\Day04\\src\\filereader\\filereaderexample\\example.txt"; // Change this to your file path

        try {
            // Create a FileReader to read the file
            FileReader fileReader = new FileReader(filePath);
            // Wrap it with BufferedReader for efficient line reading
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            // Read and print each line until end of file
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            // Close the file resources
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
