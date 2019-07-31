package birthday_celebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<Integer, Birthable>> entities = new HashMap<>();

        String line;
        String name;
        String birthdate;
        String id;
        String year;
        while (!"End".equals(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");

            switch (tokens[0]) {
                case "Citizen":
                    name = tokens[1];
                    int age = Integer.parseInt(tokens[2]);
                    id = tokens[3];
                    birthdate = tokens[4];
                    year = birthdate.split("/")[2];
                    Citizen citizen = new Citizen(name, age, id, birthdate);
                    if (!entities.containsKey(year)) {
                        entities.put(year, new HashMap<>());
                    }
                    entities.get(year).put(entities.get(year).size() + 1, citizen);
                    break;
                case "Pet":
                    name = tokens[1];
                    birthdate = tokens[2];
                    year = birthdate.split("/")[2];
                    Pet pet = new Pet(name, birthdate);
                    if (!entities.containsKey(year)) {
                        entities.put(year, new HashMap<>());
                    }
                    entities.get(year).put(entities.get(year).size() + 1, pet);
                    break;
                case "Robot":
                    String model = tokens[1];
                    id = tokens[2];
                    Robot robot = new Robot(id, model);
                    break;
            }
        }

        year = reader.readLine();
        for (Birthable kvp : entities.get(year).values()) {
            System.out.println(kvp.getBirthDate());
        }
    }
}
