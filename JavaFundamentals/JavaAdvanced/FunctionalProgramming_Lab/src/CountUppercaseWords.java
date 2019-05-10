import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");

        Predicate<String> startsWithUpperCase = x -> x.charAt(0) == x.toUpperCase().charAt(0);

        ArrayList<String> upperCaseWords = new ArrayList<>();
        Arrays.stream(input)
                .filter(startsWithUpperCase)
                .forEach(s -> upperCaseWords.add(s));

        System.out.println(upperCaseWords.size());
        upperCaseWords.forEach(System.out::println);
    }
}
