import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> uniqueNumbers = new HashSet<>();

        System.out.println("Enter 5 numbers between 10 and 100 inclusive:");

        for (int i = 0; i < 5; i++) {
            int number = scanner.nextInt();

            // Check if the number is within the range and not a duplicate
            if (number >= 10 && number <= 100 && uniqueNumbers.add(number)) {
                System.out.print("Unique numbers: ");
                for (int uniqueNumber : uniqueNumbers) {
                    System.out.print(uniqueNumber + " ");
                }
                System.out.println();
            } else {
                System.out.println("Duplicate or out of range number. Enter a new number:");
                i--; // Decrement i to repeat the iteration for the same position
            }
        }

        scanner.close();
    }
}
