package stringbuilder.reversestring;

public class ReverseString {
    // Method to reverse a given string using StringBuilder
    public static String reverse(String str) {
        // Create a StringBuilder with the input string
        StringBuilder sb = new StringBuilder(str);
        // Use the built-in reverse() method
        return sb.reverse().toString(); // Convert back to string and return
    }

    public static void main(String[] args) {
        String input = "hello"; // Example input string
        String reversed = reverse(input); // Call the reverse function

        // Print the original and reversed strings
        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reversed);
    }
}
