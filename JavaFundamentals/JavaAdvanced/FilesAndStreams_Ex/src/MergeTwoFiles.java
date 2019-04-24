import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) {
        String resourceFolder = "D:\\Coding\\GitHub\\Softuni\\JavaFundamentals\\JavaAdvanced\\FilesAndStreams_Ex\\resources\\";

        String firstPathString = resourceFolder + "inputOne.txt";
        String secondPathString = resourceFolder + "inputTwo.txt";
        String mergedPathStr = resourceFolder + "merged.txt";

        Path firstPath = Paths.get(firstPathString);
        Path secondPath = Paths.get(secondPathString);
        Path mergedPath = Paths.get(mergedPathStr);

        try (BufferedReader readerFirst = Files.newBufferedReader(firstPath);
             BufferedReader readerSecond = Files.newBufferedReader(secondPath)) {
            List<String> merged = new ArrayList<>();

            mergeData(readerFirst, merged);
            mergeData(readerSecond, merged);

            Files.write(mergedPath, merged);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void mergeData(BufferedReader readerFirst, List<String> merged) throws IOException {
        String line = readerFirst.readLine();
        while (line != null){
            merged.add(line);
            line = readerFirst.readLine();
        }
    }
}
