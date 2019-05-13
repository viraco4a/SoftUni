import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] bounds = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        String type = reader.readLine();
        List<Integer> numbers = new ArrayList<>();

        for (int i = bounds[0]; i <= bounds[1]; i++) {
            numbers.add(i);
        }

        Predicate<Integer> isEven = x -> x % 2 == 0;
        Predicate<Integer> isOdd = x -> x % 2 != 0;

        if (type.equals("even")) {
            numbers.stream().filter(isEven)
            .forEach(s -> System.out.print(s + " "));
        } else {
            numbers.stream().filter(isOdd)
                    .forEach(s -> System.out.print(s + " "));
        }
    }
}
