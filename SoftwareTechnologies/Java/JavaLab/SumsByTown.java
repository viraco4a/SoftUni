import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class SumsByTown {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        LinkedHashMap<String, Double> towns = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split("\\| ");
            String town = line[0].trim();
            double income = Double.parseDouble(line[1].trim());
            if(!towns.containsKey(town)){
                towns.put(town, income);
            } else {
                towns.put(town, towns.get(town) + income);
            }
        }

//Option 1:

        towns
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(e -> {
                    System.out.println(
                            String.format("%s -> %.1f",
                                    e.getKey(),
                                    e.getValue())
                    );
                });
//Option 2:
//        towns
//                .entrySet()
//                .stream()
//                .sorted(Comparator.comparing(Map.Entry::getKey))
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey,
//                        Map.Entry::getValue,
//                        (k, v) -> {throw new AssertionError(); },
//                        LinkedHashMap::new
//                ))
//                .entrySet()
//                .forEach(e -> {
//                    System.out.println(
//                            String.format("%s -> %.1f",
//                                    e.getKey(),
//                                    e.getValue())
//                    );
//                });

        //option 3:
//        List<String> sortedTowns = new ArrayList<>();
//
//        for (Map.Entry<String, Double> entry : towns.entrySet()) {
//            sortedTowns.add(entry.getKey());
//        }
//
//        Collections.sort(sortedTowns);
//
//        for (String town : sortedTowns) {
//            System.out.println(
//                    String.format("%s -> %.1f",
//                            town, towns.get(town))
//            );
//        }
        //working in judge with treeMap:
//        import java.util.Scanner;
//import java.util.TreeMap;
//
//        public class SumsByTown {
//            public static void main(String[] args) {
//                Scanner scanner = new Scanner(System.in);
//
//                TreeMap<String, Double> townSums = new TreeMap<>();
//                int n = Integer.parseInt(scanner.nextLine());
//
//                for (int i = 0; i < n; i++) {
//                    String[] input = scanner.nextLine().split("\\|");
//                    String town = input[0].trim();
//                    double money = Double.parseDouble(input[1].trim());
//
//                    if (townSums.containsKey(town)) {
//                        townSums.put(town, townSums.get(town) + money);
//                    }
//                    else {
//                        townSums.put(town, money);
//                    }
//                }
//
//                for (String key : townSums.keySet()) {
//                    System.out.println(key + " -> " + townSums.get(key));
//                }
//            }
//        }
    }
}
