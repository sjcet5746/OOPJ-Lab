import java.io.*;

public class FileSplitter {
    public static void main(String[] args) {
        String filename = "example.txt"; // Name of the original file
        int n = 3; // Number of parts to split the file into

        splitFile(filename, n);
    }

    public static void splitFile(String filename, int n) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            long fileSize = new File(filename).length();
            long partSize = fileSize / n;

            String line;
            int partNumber = 1;
            long bytesRead = 0;

            while ((line = reader.readLine()) != null) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename + ".part" + partNumber))) {
                    long bytesToRead = partSize;
                    while (bytesToRead > 0 && line != null) {
                        writer.write(line);
                        writer.newLine();
                        bytesRead += line.length();
                        line = reader.readLine();
                        bytesToRead -= line != null ? line.length() + 1 : 0;
                    }
                }

                partNumber++;
            }

            System.out.println("File splitted into " + (partNumber - 1) + " parts.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
