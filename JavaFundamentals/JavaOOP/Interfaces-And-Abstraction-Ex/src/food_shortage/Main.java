package food_shortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Buyer> buyers = new HashMap<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            if (tokens.length == 4) {
                String id = tokens[2];
                String birthdate = tokens[3];
                Citizen citizen = new Citizen(name, age, id, birthdate);
                buyers.put(name, citizen);
            } else {
                String group = tokens[2];
                Rebel rebel = new Rebel(name, age, group);
                buyers.put(name, rebel);
            }
        }

        String line;

        while (!"End".equals(line = reader.readLine())) {
            if (buyers.containsKey(line)) {
                buyers.get(line).buyFood();
            }
        }

        int total = buyers.values().stream()
                .mapToInt(Buyer::getFood)
                .sum();

        System.out.println(total);
    }
}
