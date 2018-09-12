import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class PopulationCounter {
    private static Map<String, LinkedHashMap<String, Long>> humanity = new LinkedHashMap<>();
    private static Map<String, Long> countries = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        readData(reader);
        humanity.entrySet().stream()
                .sorted((c1, c2) -> countries.get(c2.getKey()).compareTo(countries.get(c1.getKey())))
                .forEach(country -> {
                    System.out.format("%s (total population: %d)%n", country.getKey(),
                            countries.get(country.getKey()));
                    country.getValue().entrySet()
                            .stream().sorted((t1, t2) -> t2.getValue().compareTo(t1.getValue())).forEach(city -> {
                        System.out.printf("=>%s: %d%n", city.getKey(), city.getValue());
                    });
                });
    }

    private static void readData(BufferedReader reader) throws IOException {
        String input = reader.readLine();
        while (!"report".equals(input)) {
            String[] splitted = input.split("\\|");
            String city = splitted[0];
            String country = splitted[1];
            long population = Long.parseLong(splitted[2]);
            if (!humanity.containsKey(country)){
                humanity.put(country, new LinkedHashMap<>());
                countries.put(country, 0L);
            }
            if (!humanity.get(country).containsKey(city)){
                humanity.get(country).put(city, 0L);
            }
            humanity.get(country).put(city, humanity.get(country).get(city) + population);
            countries.put(country, countries.get(country) + population);
            input = reader.readLine();
        }
    }
}
