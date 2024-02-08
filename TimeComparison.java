import java.util.StringTokenizer;

public class TimeComparison {
    public static void main(String[] args) {
        String systemTime = getCurrentTime(); // Get current system time

        // Sample time intervals (can be changed)
        String[] timeIntervals = {"08:00", "12:30", "18:45"};

        boolean found = false;

        // Loop through each time interval and compare with system time
        for (String timeInterval : timeIntervals) {
            if (compareTime(systemTime, timeInterval)) {
                System.out.println("Correct time: " + systemTime + " is between " + timeInterval);
                found = true;
                break;
            }
        }

        // If system time doesn't match any time interval, prompt for retry
        if (!found) {
            System.out.println("System time is not between any of the specified time intervals. Please try again.");
        }
    }

    // Method to get current system time
    private static String getCurrentTime() {
        // For simplicity, just returning a fixed time here
        // In a real application, you would use java.time.LocalTime to get the current time
        return "13:15"; // Example system time
    }

    // Method to compare system time with a given time interval
    private static boolean compareTime(String systemTime, String timeInterval) {
        StringTokenizer systemTokenizer = new StringTokenizer(systemTime, ":");
        StringTokenizer intervalTokenizer = new StringTokenizer(timeInterval, ":");

        int systemHour = Integer.parseInt(systemTokenizer.nextToken());
        int systemMinute = Integer.parseInt(systemTokenizer.nextToken());

        int intervalHour = Integer.parseInt(intervalTokenizer.nextToken());
        int intervalMinute = Integer.parseInt(intervalTokenizer.nextToken());

        // Compare hours and minutes
        if (systemHour > intervalHour || (systemHour == intervalHour && systemMinute >= intervalMinute)) {
            return true;
        }

        return false;
    }
}
