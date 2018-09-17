import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SumBytes {
    public static void main(String[] args) {
        String resourceFolder = "D:\\Coding\\SoftUni\\JavaFundamentals\\JavaAdvanced" +
                "\\FilesAndDirectories_Ex\\resources\\";
        String inputPathString = resourceFolder + "input.txt";

        Path inputPath = Paths.get(inputPathString);

        try (BufferedReader reader = Files.newBufferedReader(inputPath)) {
            String line = reader.readLine();
            long sum = 0;
            while (line != null){
                for (char c : line.toCharArray()) {
                    sum += c;
                }
                line = reader.readLine();
            }
            System.out.println(sum);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
