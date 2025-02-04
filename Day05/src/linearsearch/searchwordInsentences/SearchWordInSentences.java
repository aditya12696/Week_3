package linearsearch.searchwordInsentences;

public class SearchWordInSentences {
    public static void main(String[] args) {
        // Example list of sentences
        String[] sentences = {
                "The quick brown fox jumps over the lazy dog.",
                "Java is a powerful programming language.",
                "Coding is fun and rewarding.",
                "Data structures and algorithms are important for interviews."
        };

        String wordToFind = "Java"; // The word we are searching for

        String result = findSentenceWithWord(sentences, wordToFind); // Call the search method

        // Print the result
        System.out.println("Result: " + result);
    }

    // Method to find the first sentence containing the specific word
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) { // Iterate through each sentence
            if (sentence.contains(word)) { // Check if the sentence contains the word
                return sentence; // Return the first matching sentence
            }
        }
        return "Not Found"; // Return "Not Found" if no match exists
    }
}
