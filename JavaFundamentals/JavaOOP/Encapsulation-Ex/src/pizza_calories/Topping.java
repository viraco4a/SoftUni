package pizza_calories;

public class Topping extends PartOfPizza {
    private ToppingType toppingType;

    public Topping(String toppingType, double weight) {
        super(weight);
        this.setToppingType(toppingType);
    }

    public ToppingType getToppingType() {
        return toppingType;
    }

    private void setToppingType(String toppingType) {
        if (!isValidToppingType(toppingType)){
            throw new IllegalArgumentException(String.format(
                    "Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = ToppingType.valueOf(toppingType.toUpperCase());
    }

    private boolean isValidToppingType(String toppingType) {
        String local = toppingType.toUpperCase();
        for (ToppingType value : ToppingType.values()) {
            if (value.name().equals(local)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public double calculateCalories() {
        return CALORY_MODIFIER * this.getWeight() * this.toppingType.getCalories();
    }

    @Override
    protected boolean validateWeight(double weight) {
        Validator.validateToppingWeight(this, weight);
        return true;
    }
}
