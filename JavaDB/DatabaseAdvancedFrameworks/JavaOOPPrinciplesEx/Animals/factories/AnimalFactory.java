package Animals.factories;

import Animals.models.*;

import static Animals.constraints.Constraints.FEMALE;
import static Animals.constraints.Constraints.INVALID_INPUT;
import static Animals.constraints.Constraints.MALE;

public class AnimalFactory {
    public Animal CreateAnimal(String type, String name, int age,
                               String gender){
        Animal animal = null;
        switch (type){
            case "Dog":
                animal = new Dog(name, age, gender);
                break;
            case "Cat":
                animal = new Cat(name, age, gender);
                break;
            case "Frog":
                animal = new Frog(name, age, gender);
                break;
            case "Kitten":
                animal = new Kitten(name, age, FEMALE);
                break;
            case "Tomcat":
                animal = new Tomcat(name, age, MALE);
                break;
                default:
                    throw new IllegalArgumentException(INVALID_INPUT);
        }
        return animal;
    }
}
