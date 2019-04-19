import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) {
        String resourceFolder = "D:\\Coding\\GitHub\\Softuni\\JavaFundamentals\\JavaAdvanced\\FilesAndStreams_Lab\\Resources";
        Path inputPath = Paths.get(resourceFolder + "\\input.txt");
        Path outputPath = Paths.get(resourceFolder + "\\sortLines.txt");

        try {
            List<String> lines = Files.readAllLines(inputPath);

            Collections.sort(lines);

            Files.write(outputPath, lines);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
