package Animals.Core;

import Animals.factories.AnimalFactory;
import Animals.models.Animal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static Animals.constraints.Constraints.*;

public class Engine {
    private AnimalFactory animalFactory;

    public Engine() {
        this.animalFactory = new AnimalFactory();
    }

    public void run(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int index = 0;
        String type = "";

        while (true){
            try {
                String input = reader.readLine();

                if (STOP_COMMAND.equals(input)){
                    break;
                }

                if (index % 2 == 0){
                    type = input;
                } else {
                    String[] tokens = input.split(TOKENS_SEPARATOR);
                    String name = tokens[0];
                    int age = Integer.parseInt(tokens[1]);
                    String gender = tokens[2];
                    Animal animal = animalFactory.CreateAnimal(type, name, age, gender);
                    System.out.println(animal.toString());
                    System.out.println(animal.produceSound());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }
            index ++;
        }
    }
}
