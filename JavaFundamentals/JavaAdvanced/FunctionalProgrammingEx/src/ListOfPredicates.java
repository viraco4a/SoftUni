import javax.xml.stream.FactoryConfigurationError;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        List<Predicate<Integer>> predicates = new ArrayList<>();

        for (int number : numbers) {
            Predicate<Integer> predicate = x -> x % number == 0;
            predicates.add(predicate);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            boolean can = true;
            for (Predicate<Integer> predicate : predicates) {
                if (!predicate.test(i)) {
                    can = false;
                    break;
                }
            }
            if (can) {
                result.add(i);
            }
        }

        result.forEach(x -> System.out.print(x + " "));
    }
}
