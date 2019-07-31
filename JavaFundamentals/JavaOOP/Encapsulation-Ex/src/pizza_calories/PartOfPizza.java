package pizza_calories;

public abstract class PartOfPizza {
    protected static final int CALORY_MODIFIER = 2;
    private double weight;

    protected PartOfPizza(double weight) {
        this.setWeight(weight);
    }

    private void setWeight(double weight) {
        if(validateWeight(weight)) {
            this.weight = weight;
        }
    }

    protected double getWeight() {
        return this.weight;
    }

    public abstract double calculateCalories();

    protected abstract boolean validateWeight(double weight);
}
