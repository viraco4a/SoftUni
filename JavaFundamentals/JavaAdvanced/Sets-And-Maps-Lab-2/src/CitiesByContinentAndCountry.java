import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Map<String, Map<String, List<String>>> world = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String continent = tokens[0];
            String country = tokens[1];
            String town = tokens[2];

            if (!world.containsKey(continent)) {
                world.put(continent, new LinkedHashMap<>());
            }

            if (!world.get(continent).containsKey(country)) {
                world.get(continent).put(country, new ArrayList<>());
            }

            world.get(continent).get(country).add(town);
        }

        StringBuilder sb = new StringBuilder();

        world.forEach((country, v) -> {
            sb.append(country).append(":").append(System.lineSeparator());
            v.forEach((city, towns) -> {
                sb.append("  ").append(city).append(" -> ");
                sb.append(String.join(", ", towns));
                sb.append(System.lineSeparator());
            });
        });

        System.out.println(sb.toString());
    }
}
