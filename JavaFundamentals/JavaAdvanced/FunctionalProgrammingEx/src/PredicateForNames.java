import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(reader.readLine());

        String[] names = reader.readLine().split("\\s+");

        Predicate<String> isShort = x -> x.length() <= length;

        Arrays.stream(names)
                .filter(isShort)
                .forEach(System.out::println);
    }
}