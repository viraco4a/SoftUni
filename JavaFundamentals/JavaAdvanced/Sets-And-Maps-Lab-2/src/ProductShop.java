import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Double>> collection = new TreeMap<>();

        String input = reader.readLine();
        while (!input.equals("Revision")) {
            String[] tokens = input.split(", ");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            if (!collection.containsKey(shop)) {
                collection.put(shop, new LinkedHashMap<>());
            }

            collection.get(shop).put(product, price);

            input = reader.readLine();
        }

        StringBuilder sb = new StringBuilder();

        collection.forEach((k, v) -> {
            sb.append(k).append("->").append(System.lineSeparator());
            v.forEach((key, price) -> {
                sb.append("Product: ")
                        .append(key)
                        .append(", Price: ")
                        .append(String.format("%.1f", price))
                        .append(System.lineSeparator());
            });
        });

        System.out.println(sb.toString());
    }
}