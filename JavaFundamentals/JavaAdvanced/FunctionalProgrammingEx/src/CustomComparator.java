import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] numbersAsStr = reader.readLine().split("\\s+");
        Integer[] numbers = new Integer[numbersAsStr.length];
        for (int i = 0; i < numbersAsStr.length; i++) {
            numbers[i] = Integer.parseInt(numbersAsStr[i]);
        }

        Comparator<Integer> comparator = (first, second) -> {
            if (first % 2 == 0 && second % 2 != 0) {
                return -1;
            } else if (first % 2 != 0 && second % 2 == 0) {
                return 1;
            } else {
                return first - second;
            }
        };

        Arrays.stream(numbers)
                .sorted(comparator)
                .forEach(x -> System.out.print(x + " "));
    }
}
