import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileStats {
    public static void main(String[] args) {
        String filename = "example.txt"; // Name of the text file
        try {
            int[] stats = getFileStats(filename);
            System.out.println("Number of characters: " + stats[0]);
            System.out.println("Number of words: " + stats[1]);
            System.out.println("Number of lines: " + stats[2]);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    public static int[] getFileStats(String filename) throws IOException {
        int numChars = 0;
        int numWords = 0;
        int numLines = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                numChars += line.length(); // Count characters in each line
                numWords += line.split("\\s+").length; // Count words in each line
                numLines++; // Count lines
            }
        }

        return new int[]{numChars, numWords, numLines};
    }
}
