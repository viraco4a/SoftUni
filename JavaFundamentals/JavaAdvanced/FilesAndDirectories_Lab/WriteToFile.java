import java.io.FileInputStream;
import java.io.IOException;

public class WriteToFile {
    public static void main(String[] args) {
        String resourceFolder = "D:\\Coding\\SoftUni\\JavaFundamentals\\JavaAdvanced" +
                "\\FilesAndDirectories_Lab\\FilesAndDirectories_Lab\\resources\\";

        String inputPath = resourceFolder + "input.txt";
        String ouputPath = resourceFolder + "output.txt";

        try (FileInputStream fis = new FileInputStream(inputPath)) {
            //TODO
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
