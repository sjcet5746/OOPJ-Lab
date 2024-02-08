// Custom exception class
class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}

// Class with a method that throws the custom exception
class NumberProcessor {
    void processNumber(int number) throws NegativeNumberException {
        if (number < 0) {
            throw new NegativeNumberException("Negative numbers are not allowed!");
        } else {
            System.out.println("Number processed successfully: " + number);
        }
    }
}

public class Main5 {
    public static void main(String[] args) {
        NumberProcessor processor = new NumberProcessor();
        int[] numbers = {5, -3, 10, -8};

        for (int number : numbers) {
            try {
                processor.processNumber(number);
            } catch (NegativeNumberException e) {
                System.out.println("Exception caught: " + e.getMessage());
            }
        }
    }
}
