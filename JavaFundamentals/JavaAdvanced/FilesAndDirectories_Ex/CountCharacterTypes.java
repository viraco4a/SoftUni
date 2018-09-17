import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CountCharacterTypes {
    public static void main(String[] args) {
        String resourceFolder = "D:\\Coding\\SoftUni\\JavaFundamentals\\JavaAdvanced" +
                "\\FilesAndDirectories_Ex\\resources\\";
        String inputPathString = resourceFolder + "input.txt";
        String outputPathString = resourceFolder + "output.txt";

        Path inputPath = Paths.get(inputPathString);
        Path outputPath = Paths.get(outputPathString);

        try (BufferedReader reader = Files.newBufferedReader(inputPath)) {
            int vowels = 0;
            int consonants = 0;
            int punctuations = 0;
            String line = reader.readLine();

            while (line != null) {
                String[] words = line.split("\\s");
                for (String word : words) {
                    for (char c : word.toCharArray()) {
                        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                            vowels++;
                        } else if (c == '?' || c == '.' || c == '!' || c == ','){
                            punctuations++;
                        } else {
                            consonants++;
                        }
                    }
                }
                line = reader.readLine();
            }
            System.out.printf("Vowels: %d%n", vowels);
            System.out.printf("Consonants: %d%n", consonants);
            System.out.printf("Punctuation: %d%n", punctuations);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
