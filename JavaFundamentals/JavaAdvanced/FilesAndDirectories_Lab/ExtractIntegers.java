import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        String resourceFolder = "C:\\Coding\\SoftUni\\JavaFundamentals\\JavaAdvanced" +
                "\\FilesAndDirectories_Lab\\resources\\";

        String inputPath = resourceFolder + "input.txt";
        String outputPath = resourceFolder + "output.txt";

        try (Scanner scanner = new Scanner(new FileInputStream(inputPath));
             PrintWriter writer = new PrintWriter(new FileOutputStream(outputPath))) {
            while (scanner.hasNext()){
                if (scanner.hasNextInt()){
                    writer.println(scanner.nextInt());
                }
                scanner.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
