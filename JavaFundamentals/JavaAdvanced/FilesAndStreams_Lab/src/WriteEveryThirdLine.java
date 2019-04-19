import java.io.*;
import java.util.Scanner;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String path = "D:\\Coding\\GitHub\\Softuni\\JavaFundamentals\\JavaAdvanced\\FilesAndStreams_Lab\\Resources";
        String inputPath = path + "\\input.txt";
        String outputPath = path + "\\writeEveryThirdLine.txt";

        BufferedReader in = null;
        PrintWriter out = null;


        try {
            in = new BufferedReader(new FileReader(inputPath));
            out = new PrintWriter(new FileWriter(outputPath));

            int counter = 1;
            String line = in.readLine();
            while (line != null) {
                if (counter % 3 == 0) {
                    out.println(line);
                }
                counter++;

                line = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
