import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> people = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toList());

        Map<String, List<Predicate<String>>> filters = new HashMap<>();

        String line = reader.readLine();

        while (!"Print".equals(line)) {

            String[] splittedLine = line.split(";");
            String command = splittedLine[0];
            String type = splittedLine[1];
            String symbol = splittedLine[2];

            Predicate<String> predicate = null;
            switch (type){
                case "Starts with":
                    predicate = x -> x.startsWith(symbol);
                    break;
                case "Ends with":
                    predicate = x -> x.endsWith(symbol);
                    break;
                case "Length":
                    predicate = x -> x.length() == Integer.parseInt(symbol);
                    break;
                case "Contains":
                    predicate = x -> x.contains(symbol);
                    break;
            }

            if (command.startsWith("Add")){
                if (!filters.containsKey(type + symbol)) {
                    filters.put(type + symbol, new ArrayList<>());
                }
                filters.get(type + symbol).add(predicate);
            } else if (command.startsWith("Remove")) {
                filters.remove(type + symbol);
            }

            line = reader.readLine();
        }

        List<String> result = new ArrayList<>();

        for (String person : people) {
            boolean remove = false;
            for (List<Predicate<String>> predicates : filters.values()) {
                for (Predicate<String> predicate : predicates) {
                    if (predicate.test(person)){
                        remove = true;
                        break;
                    }
                }
                if (remove){
                    break;
                }
            }
            if (!remove){
                result.add(person);
            }
        }

        print(result);
    }

    private static void print(List<String> people) {
        StringBuilder sb = new StringBuilder();

        for (String person : people) {
            sb.append(person).append(" ");
        }

        System.out.println(sb.toString());
    }
}
