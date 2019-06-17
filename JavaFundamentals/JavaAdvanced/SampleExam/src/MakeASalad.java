import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class MakeASalad {
    private static final int TOMATO_CALORIES = 80;
    private static final int CARROT_CALORIES = 136;
    private static final int LETTUCE_CALORIES = 109;
    private static final int POTATO_CALORIES = 215;

    private static ArrayDeque<String> vegetablesQueue = new ArrayDeque<>();
    private static ArrayDeque<Integer> caloriesStack = new ArrayDeque<>();
    private static List<Integer> salads = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        for (String vegetable : input) {
            vegetablesQueue.offer(vegetable);
        }
        input = reader.readLine().split("\\s+");
        for (String calorie : input) {
            caloriesStack.push(Integer.parseInt(calorie));
        }

        while (!vegetablesQueue.isEmpty() && !caloriesStack.isEmpty()) {
            int calorie = caloriesStack.pop();
            int current = calorie;
            while (current > 0 && !vegetablesQueue.isEmpty()) {
                String vegetable = vegetablesQueue.poll();
                switch (vegetable) {
                    case "tomato":
                        current -= TOMATO_CALORIES;
                        break;
                    case "carrot":
                        current -= CARROT_CALORIES;
                        break;
                    case "lettuce":
                        current -= LETTUCE_CALORIES;
                        break;
                    case "potato":
                        current -= POTATO_CALORIES;
                        break;
                }
            }
            salads.add(calorie);
        }

        salads.forEach(e -> System.out.print(e + " "));
        System.out.println();
        StringBuilder sb = new StringBuilder();

        if (caloriesStack.isEmpty()) {
            for (String vegetable : vegetablesQueue) {
                sb.append(vegetable).append(" ");
            }
        } else if (vegetablesQueue.isEmpty()) {
            for (Integer calorie : caloriesStack) {
                sb.append(calorie).append(" ");
            }
        }

        System.out.println(sb.toString());
    }
}
