import java.io.File;
import java.util.Scanner;

public class FileInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        File file = new File(fileName);

        if (file.exists()) {
            System.out.println("File exists: Yes");
            System.out.println("Readable: " + (file.canRead() ? "Yes" : "No"));
            System.out.println("Writable: " + (file.canWrite() ? "Yes" : "No"));
            System.out.println("File type: " + getFileType(file));
            System.out.println("File length (bytes): " + file.length());
        } else {
            System.out.println("File does not exist.");
        }

        scanner.close();
    }

    private static String getFileType(File file) {
        if (file.isDirectory()) {
            return "Directory";
        } else if (file.isFile()) {
            return "Regular File";
        } else {
            return "Unknown";
        }
    }
}
