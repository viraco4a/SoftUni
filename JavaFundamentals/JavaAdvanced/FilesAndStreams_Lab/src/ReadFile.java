import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "D:\\Coding\\GitHub\\Softuni\\JavaFundamentals\\JavaAdvanced\\" +
                "FilesAndStreams_Lab\\Resources\\input.txt";
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(path);

            int byteDate = inputStream.read();
            while (byteDate >= 0) {
                System.out.print(Integer.toBinaryString(byteDate) + " ");

                byteDate = inputStream.read();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}
