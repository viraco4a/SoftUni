import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SpaceshipCrafting {
    private static final int GLASS = 25;
    private static final int ALUMINIUM = 50;
    private static final int LITHIUM = 75;
    private static final int CARBON_FIBER = 100;
    private static Deque<Integer> liquidDeque = new ArrayDeque<>();
    private static Deque<Integer> materialsStack = new ArrayDeque<>();
    private static Map<Integer, Integer> advancedMaterials = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {

        initiateAdvancedMaterials();

        readAllData();

        while (!liquidDeque.isEmpty() && !materialsStack.isEmpty()) {
            int liquid = liquidDeque.poll();
            int material = materialsStack.pop();
            int sum = liquid + material;
            if (advancedMaterials.containsKey(sum)) {
                advancedMaterials.put(sum, advancedMaterials.get(sum) + 1);
            } else {
                materialsStack.push(material + 3);
            }
        }
        print();
    }

    private static void print() {
        printAdv();

        printLiquids();

        printMaterials();

        printAdvancedMaterials();
    }

    private static void printAdvancedMaterials() {
        System.out.println("Aluminium: " + advancedMaterials.get(ALUMINIUM));
        System.out.println("Carbon fiber: " + advancedMaterials.get(CARBON_FIBER));
        System.out.println("Glass: " + advancedMaterials.get(GLASS));
        System.out.println("Lithium: " + advancedMaterials.get(LITHIUM));
    }

    private static void printMaterials() {
        if (materialsStack.isEmpty()) {
            System.out.println("Physical items left: none");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Physical items left: ");
            while (!materialsStack.isEmpty()) {
                sb.append(materialsStack.pop()).append(", ");
            }
            formatStringBuilder(sb);
        }
    }

    private static void formatStringBuilder(StringBuilder sb) {
        String result = sb.toString().trim();
        result = result.substring(0, result.length() - 1);
        System.out.println(result);
    }

    private static void printLiquids() {
        if (liquidDeque.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Liquids left: ");
            while (!liquidDeque.isEmpty()) {
                sb.append(liquidDeque.poll()).append(", ");
            }
            formatStringBuilder(sb);
        }
    }

    private static void printAdv() {
        if (hasFoundIt()) {
            System.out.println("Wohoo! You succeeded in building the spaceship!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to build the spaceship.");
        }
    }

    private static boolean hasFoundIt() {
        for (Integer integer : advancedMaterials.values()) {
            if (integer == 0){
                return false;
            }
        }
        return true;
    }

    private static void readAllData() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        int[] items = getData(reader);
        for (int item : items) {
            liquidDeque.offer(item);
        }
        items = getData(reader);
        for (int item : items) {
            materialsStack.push(item);
        }
    }

    private static void initiateAdvancedMaterials() {
        advancedMaterials.put(ALUMINIUM, 0);
        advancedMaterials.put(CARBON_FIBER, 0);
        advancedMaterials.put(GLASS, 0);
        advancedMaterials.put(LITHIUM, 0);
    }

    private static int[] getData(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
    }
}
