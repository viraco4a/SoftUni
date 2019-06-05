import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        List<String> people = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toList());

        String line = reader.readLine();

        while (!"Party!".equals(line)) {

            String[] splittedLine = line.split("\\s+");
            String command = splittedLine[1];
            String symbol = splittedLine[2];
            Predicate<String> predicate = null;
            switch (command) {
                case "StartsWith":
                    predicate = x -> x.startsWith(symbol);
                    break;
                case "EndsWith":
                    predicate = x -> x.endsWith(symbol);
                    break;
                case "Length":
                    predicate = x -> x.length() == Integer.parseInt(symbol);
                    break;
            }
            if ("Remove".equals(splittedLine[0])){
                if (predicate != null) {
                    people = people.stream()
                            .filter(predicate.negate())
                            .collect(Collectors.toList());
                }
            } else if ("Double".equals(splittedLine[0])){
                if (predicate != null) {
                    List<String> bonus = people.stream()
                            .filter(predicate)
                            .collect(Collectors.toList());
                    people.addAll(bonus);
                }
            }

            line = reader.readLine();
        }

        people.sort(String::compareTo);

        if (people.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            print(people);
        }
    }

    private static void print(List<String> people) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < people.size(); i++) {
            if (i != people.size() - 1){
                sb.append(people.get(i)).append(", ");
            } else {
                sb.append(people.get(i)).append(" are going to the party!");
            }
        }

        System.out.println(sb.toString());
    }
}
