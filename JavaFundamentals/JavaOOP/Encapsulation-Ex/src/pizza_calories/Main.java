package pizza_calories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] pizzaTokens = reader.readLine().split("\\s+");
            String name = pizzaTokens[1];
            int toppingNumber = Integer.parseInt(pizzaTokens[pizzaTokens.length - 1]);
            Pizza pizza = new Pizza(name, toppingNumber);

            String[] doughTokens = reader.readLine().split("\\s+");
            String flourType = doughTokens[1];
            String bakingTechnique = doughTokens[2];
            int weightInGrams = Integer.parseInt(doughTokens[doughTokens.length - 1]);
            Dough dough = new Dough(flourType.toUpperCase(), bakingTechnique.toUpperCase(), weightInGrams);

            pizza.setDough(dough);

            String line;
            while (!"END".equals(line = reader.readLine())) {
                String[] toppingTokens = line.split("\\s+");
                String toppingType = toppingTokens[1];
                int toppingWeightInGrams = Integer.parseInt(toppingTokens[toppingTokens.length - 1]);
                Topping topping = new Topping(toppingType, toppingWeightInGrams);
                pizza.addTopping(topping);
            }
            System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
