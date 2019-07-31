package pizza_calories;

public class Validator {
    private static String NOT_VALID_TEXT = "";
    private static double TEXT_MAX_LENGTH = 15;
    private static double DOUGH_WEIGHT_LOW_LIMIT = 1;
    private static double DOUGH_WEIGHT_HIGH_LIMIT = 200;
    private static double TOPPING_WEIGHT_LOW_LIMIT = 1;
    private static double TOPPING_WEIGHT_HIGH_LIMIT = 50;
    private static double TOPPING_NUMBER_LOW_LIMIT = 0;
    private static double TOPPING_NUMBER_HIGH_LIMIT = 10;

    public static void validateDoughWeight(double weight) {
        if (weight < DOUGH_WEIGHT_LOW_LIMIT ||
                weight > DOUGH_WEIGHT_HIGH_LIMIT) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

    public static void validateToppingWeight(Topping topping, double weight) {
        if (weight < TOPPING_WEIGHT_LOW_LIMIT ||
                weight > TOPPING_WEIGHT_HIGH_LIMIT) {
            throw new IllegalArgumentException(String.format(
                    "%s weight should be in the range [1..200].",
                    String.valueOf(topping.getToppingType())));
        }
    }

    public static void validatePizzaName(String name) {
        if (name.trim().equals(NOT_VALID_TEXT) || name.isEmpty() ||
        name.length() > TEXT_MAX_LENGTH) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols");
        }
    }

    public static void validateNumberOfToppings(int number) {
        if (number < TOPPING_NUMBER_LOW_LIMIT || number > TOPPING_NUMBER_HIGH_LIMIT) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }
}
