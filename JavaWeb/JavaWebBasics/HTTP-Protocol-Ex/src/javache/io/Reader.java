package javache.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class Reader {

    public static String readAllLines(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        StringBuilder sb = new StringBuilder();

        while(reader.ready()){
            sb.append((char)reader.read());
        }

        return sb.toString();
    }
}
