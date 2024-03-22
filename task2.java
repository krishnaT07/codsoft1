import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class WordGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "";

        System.out.println("Enter '1' to enter text manually or '2' to provide a file path:");
        String option = scanner.nextLine();

        if (option.equals("1")) {
            System.out.println("Enter your text:");
            text = scanner.nextLine();
        } else if (option.equals("2")) {
            System.out.println("Enter the file path:");
            String filePath = scanner.nextLine();
            try {
                text = readFile(filePath);
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
                return;
            }
        } else {
            System.out.println("Invalid option.");
            return;
        }

        int wordCount = countWords(text);
        System.out.println("Total words: " + wordCount);

        // Enhancements
        Map<String, Integer> wordFrequency = getWordFrequency(text);
        System.out.println("Word Frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static String readFile(String filePath) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(filePath));
        StringBuilder stringBuilder = new StringBuilder();
        while (fileScanner.hasNextLine()) {
            stringBuilder.append(fileScanner.nextLine()).append("\n");
        }
        fileScanner.close();
        return stringBuilder.toString();
    }

    public static int countWords(String text) {
        String[] words = text.split("[\\s\\p{Punct}]+");
        return words.length;
    }

    // Enhancement: Get word frequency
    public static Map<String, Integer> getWordFrequency(String text) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        String[] words = text.split("[\\s\\p{Punct}]+");
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        return wordFrequency;
    }
}
