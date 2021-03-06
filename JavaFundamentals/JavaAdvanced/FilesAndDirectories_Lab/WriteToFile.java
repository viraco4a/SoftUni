import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) {
        String resourceFolder = "C:\\Coding\\SoftUni\\JavaFundamentals\\JavaAdvanced" +
                "\\FilesAndDirectories_Lab\\resources\\";

        String inputPath = resourceFolder + "input.txt";
        String ouputPath = resourceFolder + "output.txt";

        Set<Character> punctoation = new HashSet<>();
        Collections.addAll(punctoation, '.', ',', '!', '?');

        try (FileInputStream fis = new FileInputStream(inputPath);
             FileOutputStream fos = new FileOutputStream(ouputPath)) {
            int oneByte = fis.read();

            while (oneByte >= 0){
                if (!punctoation.contains((char)oneByte)){
                    fos.write(oneByte);
                }
                oneByte = fis.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
