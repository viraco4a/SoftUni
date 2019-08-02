package wild_farm;

public class Zebra extends Mammal {
    public Zebra(String animalName, String animalType, Double animalWeight, Integer foodEaten, String livingRegion) {
        super(animalName, animalType, animalWeight, foodEaten, livingRegion);
    }

    @Override
    protected void makeSound() {
        System.out.println("Zs");
    }

    @Override
    protected void eat(Food food) {
        if (food instanceof Vegetable) {
            this.addFood(food.getQuantity());
        } else {
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
    }
}
