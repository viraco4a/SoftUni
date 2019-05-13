import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(",\\s+");

        List<Double> numbers = new ArrayList<>();
        for (String s : input) {
            numbers.add(Double.parseDouble(s));
        }

//        UnaryOperator<Double> addVat = x -> x * 1.2;

        Function<List<Double>, List<Double>> addVat = a1 -> {
            List<Double> vats = new ArrayList<>();
            for (Double a : a1) {
                vats.add(a * 1.2);
            }
            return vats;
        };

//        System.out.println("Prices with VAT:");
//        numbers.forEach(x -> {
//            double priceWithVAT = addVat.apply(x);
//            System.out.printf("%.2f%n", priceWithVAT);
//        });

        Consumer<List<Double>> print = a1 -> {
            System.out.println("Prices with VAT:");
            for (Double a : a1) {
                System.out.printf("%.2f%n", a);
            }
        };

        numbers = addVat.apply(numbers);

        print.accept(numbers);
    }
}
