import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class WordCount {
    private static Set<String> words = new HashSet<>();
    private static Map<String, Integer> counterOfwords = new LinkedHashMap<>();

    public static void main(String[] args) {
        String resourceFolder = "D:\\Coding\\SoftUni\\JavaFundamentals\\JavaAdvanced" +
                "\\FilesAndDirectories_Ex\\resources\\";
        String wordsPathString = resourceFolder + "words.txt";
        String textPathString = resourceFolder + "text.txt";
        String resultPathString = resourceFolder + "results.txt";
        Path wordsPath = Paths.get(wordsPathString);
        Path textPath = Paths.get(textPathString);
        Path resultPath = Paths.get(resultPathString);

        try (BufferedReader wordsReader = Files.newBufferedReader(wordsPath);
        BufferedReader textReader = Files.newBufferedReader(textPath)){
            readWords(wordsReader);
            checkText(textReader);
            List<String> result = new ArrayList<>();
            counterOfwords.entrySet().stream()
                    .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                    .forEach(word -> {
                        result.add(String.format("%s - %d", word.getKey(), word.getValue()));
                    });
            Files.write(resultPath, result);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void checkText(BufferedReader textReader) throws IOException {
        String line = textReader.readLine();
        while (line != null){
            String[] splitted = line.split("\\s");
            for (String s : splitted) {
                if (words.contains(s)){
                    if (!counterOfwords.containsKey(s)){
                        counterOfwords.put(s, 0);
                    }
                    counterOfwords.put(s, counterOfwords.get(s) + 1);
                }
            }
            line = textReader.readLine();
        }
    }

    private static void readWords(BufferedReader wordsReader) throws IOException {
        String line = wordsReader.readLine();
        while (line != null){
            String[] splitted = line.split("\\s");
            words.addAll(Arrays.asList(splitted));
            line = wordsReader.readLine();
        }
    }
}
