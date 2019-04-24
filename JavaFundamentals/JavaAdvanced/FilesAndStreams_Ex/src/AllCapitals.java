import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AllCapitals {
    public static void main(String[] args) {
        String resourceFolder = "D:\\Coding\\GitHub\\Softuni\\JavaFundamentals\\JavaAdvanced\\FilesAndStreams_Ex\\resources\\";
        String inputPathString = resourceFolder + "input.txt";
        String outputPathString = resourceFolder + "allCapitals.txt";

        Path inputPath = Paths.get(inputPathString);
        Path outputPath = Paths.get(outputPathString);

        try (BufferedReader reader = Files.newBufferedReader(inputPath)){
            String line = reader.readLine();
            List<String> lines = new ArrayList<>();
            while (line != null){
                lines.add(line.toUpperCase());
                line = reader.readLine();
            }
            Files.write(outputPath, lines);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
