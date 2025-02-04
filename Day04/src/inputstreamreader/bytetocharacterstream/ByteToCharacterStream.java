package inputstreamreader.bytetocharacterstream;
import java.io.*;

public class ByteToCharacterStream {
    public static void main(String[] args) {
        String filePath = "F:\\Local\\Week03\\Day04\\src\\inputstreamreader\\bytetocharacterstream\\example.txt"; // Change this to your file path

        try {
            // Create a FileInputStream to read binary data
            FileInputStream fileInputStream = new FileInputStream(filePath);

            // Wrap FileInputStream with InputStreamReader (specify UTF-8 encoding)
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");

            // Wrap InputStreamReader with BufferedReader for efficient reading
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            // Read and print each line from the file
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            // Close all streams to free resources
            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
