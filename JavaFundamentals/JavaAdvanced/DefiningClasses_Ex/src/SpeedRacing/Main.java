package SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Car> cars = new LinkedHashMap<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split("\\s+");
            String model = line[0];
            double fuelAmount = Double.parseDouble(line[1]);
            double fuelConsumption = Double.parseDouble(line[2]);
            Car car = new Car(model, fuelAmount, fuelConsumption);
            cars.put(model, car);
        }

        String line;

        while (!"End".equals(line = reader.readLine())) {
            String[] splittedLine = line.split("\\s+");
            String model = splittedLine[1];
            double distance = Double.parseDouble(splittedLine[2]);
            if (cars.containsKey(model)) {
                cars.get(model).move(distance);
            }
        }

        cars.values().forEach(c -> System.out.println(c.toString()));
    }
}
