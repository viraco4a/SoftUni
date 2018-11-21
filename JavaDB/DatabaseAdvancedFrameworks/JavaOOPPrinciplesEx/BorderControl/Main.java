package BorderControl;

import BorderControl.contracts.Identifiable;
import BorderControl.models.Citizen;
import BorderControl.models.Robot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Identifiable> population = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = reader.readLine();
            while (!"End".equals(input)){
                String[] tokens = input.split("\\s+");
                if (tokens.length == 3){
                    String name = tokens[0];
                    int age = Integer.parseInt(tokens[1]);
                    String id = tokens[2];
                    Identifiable citizen = new Citizen(name, age, id);
                    population.add(citizen);
                } else {
                    String model = tokens[0];
                    String id = tokens[1];
                    Identifiable robot = new Robot(model, id);
                    population.add(robot);
                }
                input = reader.readLine();
            }

            String code = reader.readLine().trim();
            population.stream()
                    .filter(s -> s.getId().endsWith(code))
                    .forEach(e ->{
                        System.out.println(e.getId());
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}