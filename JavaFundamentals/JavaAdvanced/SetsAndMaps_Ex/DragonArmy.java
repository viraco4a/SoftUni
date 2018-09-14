import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class DragonArmy {
    private static Map<String, Double[]> dragonTypes = new LinkedHashMap<>();
    private static Map<String, TreeMap<String, Integer[]>> dragons = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        breadingDragons();
        calcAverageParams();
        print();
    }

    private static void print() {
        dragons.entrySet().stream()
                .forEach(type -> {
                    System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type.getKey(),
                            dragonTypes.get(type.getKey())[0],
                            dragonTypes.get(type.getKey())[1],
                            dragonTypes.get(type.getKey())[2]);
                    type.getValue().entrySet().stream()
                            .forEach(dragon -> {
                                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",
                                        dragon.getKey(),
                                        dragon.getValue()[0],
                                        dragon.getValue()[1],
                                        dragon.getValue()[2]);
                            });
                });
    }

    private static void calcAverageParams() {
        for (Map.Entry<String, TreeMap<String, Integer[]>> entry : dragons.entrySet()) {
            double avrDamage = 0.0;
            double avrHealth = 0.0;
            double avrArmor = 0.0;
            for (Map.Entry<String, Integer[]> dragon : entry.getValue().entrySet()) {
                avrDamage += dragon.getValue()[0];
                avrHealth += dragon.getValue()[1];
                avrArmor += dragon.getValue()[2];
            }
            dragonTypes.get(entry.getKey())[0] = avrDamage / entry.getValue().size();
            dragonTypes.get(entry.getKey())[1] = avrHealth / entry.getValue().size();
            dragonTypes.get(entry.getKey())[2] = avrArmor / entry.getValue().size();
        }
    }

    private static void breadingDragons() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] splitted = reader.readLine().split(" ");
            String type = splitted[0];
            String name = splitted[1];
            int damage = 45;
            int health = 250;
            int armor = 10;
            if (!splitted[2].equals("null")){
                damage = Integer.parseInt(splitted[2]);
            }
            if (!splitted[3].equals("null")){
                health = Integer.parseInt(splitted[3]);
            }
            if (!splitted[4].equals("null")){
                armor = Integer.parseInt(splitted[4]);
            }
            if (!dragons.containsKey(type)){
                dragonTypes.put(type, new Double[3]);
                dragons.put(type, new TreeMap<>());
            }
            if (!dragons.get(type).containsKey(name)){
                dragons.get(type).put(name, new Integer[3]);
            }
            dragons.get(type).get(name)[0] = damage;
            dragons.get(type).get(name)[1] = health;
            dragons.get(type).get(name)[2] = armor;
        }
    }
}
