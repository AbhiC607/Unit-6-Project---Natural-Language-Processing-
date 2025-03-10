import java.util.ArrayList;
import java.util.Scanner;

public class MyNLP {

    private ArrayList<String> dictionary;
    private ArrayList<String> words;

    public MyNLP() {
        dictionary = FileReader.toStringList("wordDictionary.txt");
        words = getWordList();
    }

   private ArrayList<String> getWordList() {
    ArrayList<String> justWords = new ArrayList<>();
    for (String line : dictionary) {
        int index = line.indexOf("|"); // Find the first occurrence of "|"
        if (index > 0) { // Ensure "|" exists in the line
            String word = line.substring(0, index); // Extract the word before "|"
            justWords.add(word);
        }
    }
    return justWords;
}

    /**
     * Looks up a word in the dictionary and prints its details.
     */
    public void lookupWord(String inputWord) {
        for (String line : dictionary) {
            String[] parts = line.split("\\|"); // Expected format: word|partOfSpeech|definition|link
            if (parts.length >= 4 && parts[0].equalsIgnoreCase(inputWord)) {
                System.out.println("\nWord: " + parts[0]);
                System.out.println("Part of Speech: " + parts[1]);
                System.out.println("Definition: " + parts[2]);
                System.out.println("Link: " + parts[3]);
                return;
            }
        }
        System.out.println("\nWord not found.");
    }

    /**
     * Prompts the user for a word and looks it up.
     */
    public void prompt() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a word to look up: ");
        String userInput = input.nextLine();
        lookupWord(userInput);
        input.close();
    }

    /**
     * Prints all words from the dictionary.
     */
    public void printSummary() {
        System.out.println("\nDictionary Word List:");
        for (String word : words) {
            System.out.println(word);
        }
    }

    /**
     * Test function to demonstrate lookup with "abate"
     */
}