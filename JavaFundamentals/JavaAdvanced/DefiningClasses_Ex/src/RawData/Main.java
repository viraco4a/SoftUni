package RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

            int engineSpeed = Integer.parseInt(line[1]);
            int enginePower = Integer.parseInt(line[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(line[3]);
            String cargoType = line[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            ArrayList<Tire> tires = new ArrayList<>();
            Tire tire;

            int tire1Age = Integer.parseInt(line[6]);
            double tire1Pressure = Double.parseDouble(line[5]);
            tire = new Tire(tire1Age,tire1Pressure);
            tires.add(tire);

            int tire2Age = Integer.parseInt(line[8]);
            double tire2Pressure = Double.parseDouble(line[7]);
            tire = new Tire(tire2Age,tire2Pressure);
            tires.add(tire);

            int tire3Age = Integer.parseInt(line[10]);
            double tire3Pressure = Double.parseDouble(line[9]);
            tire = new Tire(tire3Age,tire3Pressure);
            tires.add(tire);

            int tire4Age = Integer.parseInt(line[12]);
            double tire4Pressure = Double.parseDouble(line[11]);
            tire = new Tire(tire4Age,tire4Pressure);
            tires.add(tire);

            Car car = new Car(model, engine, cargo, tires);
            cars.put(model, car);
        }

        String command = reader.readLine();

        if (command.equals("fragile")) {
            cars.values().stream()
                    .filter(car -> car.getCargo().getType().equals("fragile"))
                    .filter(car -> {
                        for (Tire tire : car.getTires()) {
                            if (tire.getPressure() < 1) {
                                return true;
                            }
                        }
                        return false;
                    })
                    .forEach(car -> System.out.println(car.getModel()));
        } else if (command.equals("flamable")){
            cars.values().stream()
                    .filter(car -> car.getCargo().getType().equals("flamable"))
                    .filter(car -> car.getEngine().getEnginePower() > 250)
                    .forEach(car -> System.out.println(car.getModel()));
        }
    }
}
