package wild_farm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Animal> animals = new ArrayList<>();

        String line;
        while (!"End".equals(line = reader.readLine())) {
            AnimalFactory animalFactory = new AnimalFactory();
            Animal animal = animalFactory.getAnimal(line.split("\\s+"));
            FoodFactory foodFactory = new FoodFactory();
            Food food = foodFactory.getFood(reader.readLine().split("\\s+"));

            animal.makeSound();

            try {
                animal.eat(food);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            animals.add(animal);
        }

        animals.forEach(System.out::println);
    }
}
