import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CountRealNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double[] line = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();
        Map<Double, Integer> numbers = new LinkedHashMap<>();

        for (double i : line) {
            if (!numbers.containsKey(i)) {
                numbers.put(i, 0);
            }
            numbers.put(i, numbers.get(i) + 1);
        }

        numbers.forEach((k, p) -> {
            System.out.printf("%.1f -> %d%n", k, p);
        });
    }
}
