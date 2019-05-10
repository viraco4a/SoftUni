import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(",\\s+");

        List<Double> numbers = new ArrayList<>();
        for (String s : input) {
            numbers.add(Double.parseDouble(s));
        }

        UnaryOperator<Double> addVat = x -> x * 1.2;

        System.out.println("Prices with VAT:");
        numbers.forEach(x -> {
            double priceWithVAT = addVat.apply(x);
            System.out.printf("%.2f%n", priceWithVAT);
        });

    }
}
