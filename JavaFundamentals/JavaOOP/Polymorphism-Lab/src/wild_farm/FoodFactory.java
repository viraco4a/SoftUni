package wild_farm;

public class FoodFactory {
    public Food getFood(String[] tokens) {
        String type = tokens[0];
        Integer quantity = Integer.valueOf(tokens[1]);
        switch (type) {
            case "Vegetable":
                return new Vegetable(quantity);
            case "Meat":
                return new Meat(quantity);
        }
        return null;
    }
}
