package CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Engine> engines = new HashMap<>();
        Map<String, Car> cars = new LinkedHashMap<>();

        readEngines(reader, engines);
        readCars(reader, engines, cars);

        cars.values().forEach(car -> System.out.println(car.toString()));

    }

    private static void readCars(BufferedReader reader, Map<String, Engine> engines, Map<String, Car> cars) throws IOException {
        int M = Integer.parseInt(reader.readLine());

        for (int i = 0; i < M; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String carModel = tokens[0];
            String engineModel = tokens[1];
            Car car = new Car(carModel, engines.get(engineModel));

            if (tokens.length == 3) {
                if (isNumeric(tokens[2])) {
                    int weight = Integer.parseInt(tokens[2]);
                    car.setWeight(weight);
                } else {
                    String color = tokens[2];
                    car.setColor(color);
                }
            } else if (tokens.length == 4) {
                int weight = Integer.parseInt(tokens[2]);
                car.setWeight(weight);
                String color = tokens[3];
                car.setColor(color);
            }

            cars.put(carModel, car);
        }
    }

    private static void readEngines(BufferedReader reader, Map<String, Engine> engines) throws IOException {
        int N = Integer.parseInt(reader.readLine());

        for (int i = 0; i < N; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            String engineModel = tokens[0];
            int power = Integer.parseInt(tokens[1]);
            Engine engine = new Engine(engineModel, power);
            if (tokens.length == 3) {
                if (isNumeric(tokens[2])) {
                    int displacement = Integer.parseInt(tokens[2]);
                    engine.setDisplacement(displacement);
                } else {
                    String efficiency = tokens[2];
                    engine.setEfficiency(efficiency);
                }
            } else if (tokens.length == 4) {
                int displacement = Integer.parseInt(tokens[2]);
                engine.setDisplacement(displacement);
                String efficiency = tokens[3];
                engine.setEfficiency(efficiency);
            }

            engines.put(engineModel, engine);
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
