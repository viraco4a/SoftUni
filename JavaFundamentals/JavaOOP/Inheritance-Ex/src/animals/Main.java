package animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Animal> animals = new ArrayList<>();

        String type;

        while (!"Beast!".equals(type = reader.readLine())) {
            try {
                String[] tokens = reader.readLine().split("\\s+");
                String gender = null;
                if (type.equals("Tomcat") || type.equals("Kitten")) {
                    if (tokens.length < 2) {
                        throw new IllegalArgumentException("Invalid input");
                    }
                } else if (tokens.length != 3) {
                    throw new IllegalArgumentException("Invalid input");
                } else {
                    gender = tokens[2];
                }
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);

                switch (type) {
                    case "Cat":
                        Animal cat = new Cat(name, age, gender);
                        animals.add(cat);
                        break;
                    case "Dog":
                        Animal dog = new Dog(name, age, gender);
                        animals.add(dog);
                        break;
                    case "Frog":
                        Animal frog = new Frog(name, age, gender);
                        animals.add(frog);
                        break;
                    case "Tomcat":
                        Animal tomcat = new Tomcat(name, age);
                        animals.add(tomcat);
                        break;
                    case "Kitten":
                        Animal kitten = new Kitten(name, age);
                        animals.add(kitten);
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        animals.forEach(System.out::println);
    }
}
