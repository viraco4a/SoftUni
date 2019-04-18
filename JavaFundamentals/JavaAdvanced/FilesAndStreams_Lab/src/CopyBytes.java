import java.io.*;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        String path = "D:\\Coding\\GitHub\\Softuni\\JavaFundamentals\\JavaAdvanced\\FilesAndStreams_Lab\\Resources";
        String inputPath = path + "\\input.txt";
        String outputPath = path + "\\copyBytes.txt";

        InputStream input = null;
        OutputStream out = null;


        try {
            input = new FileInputStream(inputPath);
            out = new FileOutputStream(outputPath);

            int oneByte = 0;
            while ((oneByte = input.read()) >= 0) {
                if (oneByte == 10 || oneByte == 32) {
                    out.write(oneByte);
                } else {
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++) {
                        out.write(digits.charAt(i));
                    }
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
