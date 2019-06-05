import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int num = Integer.parseInt(reader.readLine());

        UnaryOperator<int[]> reverseArray = arr -> {
            int[] result = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                result[arr.length - i - 1] = arr[i];
            }
            return result;
        };

        Consumer<int[]> canDivide = arr -> {
            arr = reverseArray.apply(arr);
            Arrays.stream(arr)
                    .filter(x -> x % num != 0)
                    .forEach(x -> System.out.print(x + " "));
        };

        canDivide.accept(numbers);
    }
}
