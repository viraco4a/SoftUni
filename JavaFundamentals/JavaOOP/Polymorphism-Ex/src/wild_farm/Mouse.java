package wild_farm;

public class Mouse extends Mammal {
    public Mouse(String animalName, String animalType, Double animalWeight, Integer foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
    }

    @Override
    protected void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    protected void eat(Food food) {
        if (food instanceof Vegetable) {
            this.addFood(food.getQuantity());
        } else {
            throw new IllegalArgumentException("Mice are not eating that type of food!");
        }
    }
}
