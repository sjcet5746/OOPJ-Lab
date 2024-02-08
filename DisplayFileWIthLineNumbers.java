import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DisplayFileWithLineNumbers {
    public static void main(String[] args) {
        String filename = "example.txt"; // Name of the text file
        try {
            displayFileWithLineNumbers(filename);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    public static void displayFileWithLineNumbers(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }
        }
    }
}
