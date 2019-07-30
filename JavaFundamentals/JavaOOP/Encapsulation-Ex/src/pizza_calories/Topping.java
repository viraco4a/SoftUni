package pizza_calories;

public class Topping extends PartOfPizza {
    private ToppingType toppingType;

    public Topping(String toppingType, double weight) {
        super(weight);
        this.setToppingType(toppingType);
    }

    private void setToppingType(String toppingType) {
        this.toppingType = ToppingType.valueOf(toppingType);
    }

    @Override
    public double calculateCalories() {
        return CALORY_MODIFIER * this.getWeight() * this.toppingType.getCalories();
    }
}
