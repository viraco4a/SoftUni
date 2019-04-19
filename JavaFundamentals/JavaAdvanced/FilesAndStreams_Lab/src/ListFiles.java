import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        String resourceFolder = "D:\\Coding\\GitHub\\Softuni\\JavaFundamentals\\JavaAdvanced\\FilesAndStreams_Lab\\Resources\\";

        String rootDirectoryPath = resourceFolder + "Files-and-Streams";

        File rootDir = new File(rootDirectoryPath);

        File[] files = rootDir.listFiles();

        if (files == null){
            return;
        }
        for (File file : files) {
            if (!file.isDirectory()){
                System.out.printf("%s: %s%n", file.getName(), file.length());
            }
        }
    }
}
