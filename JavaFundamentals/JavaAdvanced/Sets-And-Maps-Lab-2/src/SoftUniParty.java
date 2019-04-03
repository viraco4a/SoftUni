import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<String> regulars = new TreeSet<>();
        Set<String> vips = new TreeSet<>();

        String input = reader.readLine();
        while (!input.equals("PARTY")) {
            if (Character.isDigit(input.charAt(0))) {
                vips.add(input);
            } else {
                regulars.add(input);
            }

            input = reader.readLine();
        }

        input = reader.readLine();

        while (!input.equals("END")) {
            vips.remove(input);
            regulars.remove(input);

            input = reader.readLine();
        }

        int size = vips.size() + regulars.size();
        System.out.println(size);
        vips.forEach(System.out::println);
        regulars.forEach(System.out::println);
    }
}
