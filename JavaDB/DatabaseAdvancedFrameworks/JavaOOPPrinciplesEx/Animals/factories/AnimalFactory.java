package Animals.factories;

import Animals.models.*;

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
                animal = new Kitten(name, age, gender);
                break;
            case "Tomcat":
                animal = new Tomcat(name, age, gender);
                break;
        }
        return animal;
    }
}
