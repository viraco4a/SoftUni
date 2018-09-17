import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        String resourceFolder = "D:\\Coding\\SoftUni\\JavaFundamentals\\JavaAdvanced" +
                "\\FilesAndDirectories_Lab\\FilesAndDirectories_Lab\\resources\\";

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
