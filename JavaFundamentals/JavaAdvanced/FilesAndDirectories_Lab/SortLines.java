import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class SortLines {
    public static void main(String[] args) {
        String resourceFolder = "C:\\Coding\\SoftUni\\JavaFundamentals\\JavaAdvanced" +
                "\\FilesAndDirectories_Lab\\resources\\";

        String inputPathString = resourceFolder + "input2.txt";
        String outputPathString = resourceFolder + "output.txt";

        Path inputPath = Paths.get(inputPathString);
        Path outputPath = Paths.get(outputPathString);

        try (BufferedReader reader = Files.newBufferedReader(inputPath)){
            List<String> lines = Files.readAllLines(inputPath);

            lines.sort(String::compareTo);

            Files.write(outputPath, lines);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
