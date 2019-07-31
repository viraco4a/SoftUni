package border_control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Identifiable> population = new ArrayList<>();
        List<String> detained = new ArrayList<>();

        String line;

        while (!"End".equals(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");
            if (tokens.length == 2) {
                String model = tokens[0];
                String id = tokens[1];
                Robot robot = new Robot(id, model);
                population.add(robot);
            } else {
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String id = tokens[2];
                Citizen citizen = new Citizen(name, age, id);
                population.add(citizen);
            }
        }

        String lastDigits = reader.readLine();

        for (Identifiable identifiable : population) {
            String id = identifiable.getId();
            int index = id.length() - 1;
            boolean invalid = true;
            for (int j = lastDigits.length() - 1; j >= 0; j--) {
                if (lastDigits.charAt(j) != id.charAt(index--)) {
                    invalid = false;
                    break;
                }
            }
            if (invalid) {
                detained.add(id);
            }
        }

        detained.forEach(System.out::println);
    }
}
