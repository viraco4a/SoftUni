import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) {
        String resourceFolder = "C:\\Coding\\SoftUni\\JavaFundamentals\\JavaAdvanced" +
                "\\FilesAndDirectories_Lab\\resources\\";

        String inputPath = resourceFolder + "input.txt";
        String outputPath = resourceFolder + "output.txt";

        try (BufferedReader reader =
                     new BufferedReader(new InputStreamReader(new FileInputStream(inputPath)));
             PrintWriter writer = new PrintWriter(new FileOutputStream(outputPath))) {

            String line = reader.readLine();

            int counter = 1;
            while (line != null){

                if (counter % 3 == 0){
                    writer.println(line);
                }
                counter++;
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
