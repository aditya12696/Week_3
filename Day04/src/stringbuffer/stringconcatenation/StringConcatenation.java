package stringbuffer.stringconcatenation;

public class StringConcatenation {
    // Method to concatenate an array of strings efficiently
    public static String concatenateStrings(String[] words) {
        StringBuffer sb = new StringBuffer(); // Using StringBuffer for efficient concatenation

        // Loop through each word in the array and append it to StringBuffer
        for (String word : words) {
            sb.append(word);
        }

        return sb.toString(); // Convert and return the final concatenated string
    }

    public static void main(String[] args) {
        // Example array of strings
        String[] words = {"Hello", " ", "World", "!", " Welcome", " to", " Java"};

        // Call the method to concatenate
        String result = concatenateStrings(words);

        // Print the result
        System.out.println("Concatenated String: " + result);
    }
}
