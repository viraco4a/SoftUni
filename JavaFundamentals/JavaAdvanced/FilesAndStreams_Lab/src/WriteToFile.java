import java.io.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) throws IOException {
        String path = "D:\\Coding\\GitHub\\Softuni\\JavaFundamentals\\JavaAdvanced\\FilesAndStreams_Lab\\Resources";
        String inputPath = path + "\\input.txt";
        String outputPath = path + "\\output.txt";
        Set<Character> symbols = new HashSet<>();
        Collections.addAll(symbols, ',', '.', '!', '?');

        InputStream input = null;
        OutputStream out = null;

        try {
            input = new FileInputStream(inputPath);
            out = new FileOutputStream(outputPath);
            int oneByte = 0;
            while ((oneByte = input.read()) >= 0) {
                if (!symbols.contains((char)oneByte)) {
                    out.write(oneByte);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                input.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
