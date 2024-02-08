import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueNumbers1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> uniqueNumbers = new HashSet<>();

        System.out.println("Enter 5 numbers between 10 and 100 inclusive:");

        for (int i = 0; i < 5; i++) {
            int number = scanner.nextInt();

            // Check if the number is within the range
            if (number < 10 || number > 100) {
                System.out.println("Number out of range. Enter a new number:");
                i--; // Decrement i to repeat the iteration for the same position
                continue;
            }

            // Check if the number is a duplicate
            if (!uniqueNumbers.add(number)) {
                System.out.println("Duplicate number. Enter a new number:");
                i--; // Decrement i to repeat the iteration for the same position
                continue;
            }

            // Print the unique set of numbers
            System.out.print("Unique numbers: ");
            for (int uniqueNumber : uniqueNumbers) {
                System.out.print(uniqueNumber + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
