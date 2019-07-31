package pizza_calories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
    }

    private void setName(String name) {
        Validator.validatePizzaName(name);
        this.name = name;
    }

    private void setToppings(int toppings) {
        Validator.validateNumberOfToppings(toppings);
        this.toppings = new ArrayList<>(toppings);
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return this.name;
    }

    public void addTopping(Topping topping) {
        Validator.validateNumberOfToppings(this.toppings.size() + 1);
        this.toppings.add(topping);
    }

    public double getOverallCalories() {
        double totalCalories = this.dough.calculateCalories();
        for (Topping topping : toppings) {
            totalCalories += topping.calculateCalories();
        }
        return totalCalories;
    }
}
