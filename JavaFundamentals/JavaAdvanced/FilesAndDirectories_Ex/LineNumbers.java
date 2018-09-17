import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LineNumbers {
    public static void main(String[] args) {
        String resourceFolder = "D:\\Coding\\SoftUni\\JavaFundamentals\\JavaAdvanced" +
                "\\FilesAndDirectories_Ex\\resources\\";
        String inputPathString = resourceFolder + "inputLineNumbers.txt";
        String outputPathString = resourceFolder + "output.txt";

        Path inputPath = Paths.get(inputPathString);
        Path outputPath = Paths.get(outputPathString);

        try (BufferedReader reader = Files.newBufferedReader(inputPath)) {
            StringBuilder sb = new StringBuilder();
            String line = reader.readLine();
            int counter = 1;
            while (line != null){
                sb.append(String.valueOf(counter));
                sb.append(". ");
                sb.append(line);
                sb.append("\n");
                counter ++;
                line = reader.readLine();
            }
            List lines = new ArrayList();
            lines.add(sb.toString());
            Files.write(outputPath, lines);


        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
