import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class AppliedArithmetic {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], int[]> add = arr -> Arrays.stream(arr).map(x -> ++x).toArray();
        UnaryOperator<int[]> multiply = arr -> Arrays.stream(arr).map(x -> x * 2).toArray();
        Function<int[], int[]> subtract = arr -> Arrays.stream(arr).map(x -> --x).toArray();

        Consumer<int[]> print = arr -> {
            Arrays.stream(arr).forEach(x -> System.out.print(x + " "));
        };

        String command = reader.readLine();
        while (!"end".equals(command)){

            switch (command){
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    System.out.println();
                    break;
            }

            command = reader.readLine();
        }

    }
}
