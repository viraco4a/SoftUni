import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Largest3Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted((e1, e2) -> Integer.compare(e2, e1))
                .limit(3)
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }
}
