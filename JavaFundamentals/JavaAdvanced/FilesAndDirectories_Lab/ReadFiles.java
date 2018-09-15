import java.io.FileInputStream;
import java.io.IOException;

public class ReadFiles {
    public static void main(String[] args) {
        String resourceFolder = "C:\\Coding\\SoftUni\\JavaFundamentals\\JavaAdvanced" +
                "\\FilesAndDirectories_Lab\\resources\\";

        String path = resourceFolder + "input.txt";
        try (FileInputStream fis = new FileInputStream(path)) {
            int oneByte = fis.read();
            while (oneByte >= 0){
                System.out.printf("%s ", Integer.toBinaryString(oneByte));

                oneByte = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
