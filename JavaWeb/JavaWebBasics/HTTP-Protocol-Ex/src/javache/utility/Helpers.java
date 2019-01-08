package javache.utility;

import java.io.File;

public final class Helpers {
    public Helpers() {
    }

    public static String getExtension(File file){
        String fileName = file.getName();
        int index = fileName.lastIndexOf(".");
        return fileName.substring(index + 1);
    }
}
