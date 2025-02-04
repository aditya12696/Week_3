package inputstreamreader.userinputtofile;
import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        String filePath = "output.txt"; // File where input will be saved

        try {
            // Create InputStreamReader to read user input from console
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);

            // Wrap InputStreamReader with BufferedReader for efficient reading
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            // Create FileWriter to write user input to a file
            FileWriter fileWriter = new FileWriter(filePath);

            System.out.println("Enter text (type 'exit' to stop):");

            String userInput;
            // Read user input and write to the file
            while (!(userInput = bufferedReader.readLine()).equalsIgnoreCase("exit")) {
                fileWriter.write(userInput + "\n"); // Write each input line to the file
            }

            // Close all streams
            bufferedReader.close();
            fileWriter.close();

            System.out.println("User input saved to " + filePath);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
