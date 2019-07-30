package pizza_calories;

public enum FlourType {
    WHITE(1.5),
    WHOLEGRAIN(1.0);

    private double calories;

    FlourType(double calories) {
        this.calories = calories;
    }

    public double getCalories() {
        return this.calories;
    }
}
