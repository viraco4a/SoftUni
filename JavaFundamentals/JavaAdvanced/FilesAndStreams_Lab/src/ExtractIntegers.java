import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        String path = "D:\\Coding\\GitHub\\Softuni\\JavaFundamentals\\JavaAdvanced\\FilesAndStreams_Lab\\Resources";
        String inputPath = path + "\\input.txt";
        String outputPath = path + "\\extractIntegers.txt";

        Scanner scanner = null;
        PrintWriter out = null;


        try {
            scanner = new Scanner(new FileInputStream(inputPath));
            out = new PrintWriter(new FileOutputStream(outputPath));

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    out.println(scanner.nextInt());
                }

                scanner.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
