import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class LegendaryFarming {
    private static Map<String, Integer> legends = new LinkedHashMap<>();
    private static Map<String, Integer> junk = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        createLegends();

        while (true) {
            String[] splitted = reader.readLine().split("\\s");

            for (int i = 0; i < splitted.length; i += 2) {
                String material = splitted[i + 1].toLowerCase();
                int count = Integer.valueOf(splitted[i]);
                if (legends.containsKey(material)) {
                    legends.put(material, legends.get(material) + count);
                    if (legends.get(material) >= 250) {
                        legends.put(material, legends.get(material) - 250);
                        print(material);
                        return;
                    }
                } else {
                    fillJunk(material, count);
                }
            }
        }
    }

    private static void fillJunk(String material, int count) {
        if (!junk.containsKey(material)) {
            junk.put(material, 0);
        }
        junk.put(material, junk.get(material) + count);
    }

    private static void print(String material) {
        printObtainedLegendary(material);
        printLegendaryMaterials();
        printJunk();
    }

    private static void printJunk() {
        junk.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(mat -> {
                    System.out.printf("%s: %d%n", mat.getKey(), mat.getValue());
                });
    }

    private static void printLegendaryMaterials() {
        legends.entrySet().stream()
                .sorted((c1, c2) ->{
                   if (c1.getValue() == c2.getValue()){
                       return c1.getKey().compareTo(c2.getKey());
                   } else {
                       return c2.getValue() - c1.getValue();
                   }
                })
                .forEach(mat -> {
                    System.out.printf("%s: %d%n", mat.getKey(), mat.getValue());
                });
    }

    private static void printObtainedLegendary(String material) {
        switch (material) {
            case "shards":
                System.out.println("Shadowmourne obtained!");
                break;
            case "fragments":
                System.out.println("Valanyr obtained!");
                break;
            case "motes":
                System.out.println("Dragonwrath obtained!");
                break;
        }
    }

    private static void createLegends() {
        legends.put("shards", 0);
        legends.put("fragments", 0);
        legends.put("motes", 0);
    }
}
