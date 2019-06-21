package GenericCountMethodStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Box<String> box = new Box<>();
        for (int i = 0; i < n; i++) {
            //Integer number = Integer.parseInt(reader.readLine());
            String line = reader.readLine();
            box.add(line);
        }
        String other = reader.readLine();

        int count = box.count(other);

        System.out.println(count);
    }
}
