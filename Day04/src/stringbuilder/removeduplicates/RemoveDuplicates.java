package stringbuilder.removeduplicates;
import java.util.HashSet;

public class RemoveDuplicates {
    // Method to remove duplicate characters while maintaining order
    public static String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder(); // To store the result without duplicates
        HashSet<Character> seen = new HashSet<>(); // To track characters we've already added

        // Loop through each character in the string
        for (char c : str.toCharArray()) {
            // If the character is new, add it to StringBuilder and HashSet
            if (!seen.contains(c)) {
                sb.append(c);
                seen.add(c);
            }
        }
        return sb.toString(); // Convert and return the final result
    }

    public static void main(String[] args) {
        String input = "programming"; // Example input string
        String result = removeDuplicates(input); // Call the method

        // Print the original and modified strings
        System.out.println("Original: " + input);
        System.out.println("Without Duplicates: " + result);
    }
}
