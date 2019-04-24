import java.io.File;

public class GetFolderSize {
    private static long size;

    public static void main(String[] args) {
        String resourceFolder = "D:\\Coding\\GitHub\\Softuni\\JavaFundamentals\\JavaAdvanced\\FilesAndStreams_Ex\\resources\\";

        String rootDirectoryPath = resourceFolder + "Exercises Resources";
        File rootDir = new File(rootDirectoryPath);


        CalculateSize(rootDir);

        System.out.printf("Folder size: %d", size);
    }

    private static void CalculateSize(File rootDir) {
        File[] files = rootDir.listFiles();
        if (!rootDir.exists()){
            return;
        }
        if (files == null){
            return;
        }

        for (File file : files) {
            if (file.isDirectory()){
                CalculateSize(file);
            }
            size += file.length();
        }
    }
}
