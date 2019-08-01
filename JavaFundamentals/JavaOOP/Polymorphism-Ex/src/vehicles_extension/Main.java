package vehicles_extension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] carData = reader.readLine().split("\\s+");
        String[] truckData = reader.readLine().split("\\s+");
        String[] busData = reader.readLine().split("\\s+");

        Vehicle car = new Car(
                Double.parseDouble(carData[1]),
                Double.parseDouble(carData[2]),
                Double.parseDouble(carData[3]));
        Vehicle truck = new Truck(
                Double.parseDouble(truckData[1]),
                Double.parseDouble(truckData[2]),
                Double.parseDouble(truckData[3]));
        Bus bus = new Bus(
                Double.parseDouble(busData[1]),
                Double.parseDouble(busData[2]),
                Double.parseDouble(busData[3]));

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            try {
                switch (tokens[0]) {
                    case "Drive":
                        if (tokens[1].equals("Car")) {
                            car.drive(Double.parseDouble(tokens[2]));
                        } else if (tokens[1].equals("Truck")) {
                            truck.drive(Double.parseDouble(tokens[2]));
                        } else {
                            bus.drive(Double.parseDouble(tokens[2]));
                        }
                        break;
                    case "Refuel":
                        if (tokens[1].equals("Car")) {
                            car.refuel(Double.parseDouble(tokens[2]));
                        } else if (tokens[1].equals("Truck")) {
                            truck.refuel(Double.parseDouble(tokens[2]));
                        } else {
                            bus.refuel(Double.parseDouble(tokens[2]));
                        }
                        break;
                    default:
                        bus.driveEmpty(Double.parseDouble(tokens[2]));
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(String.format("Car: %.2f", car.getFuelQuantity()));
        System.out.println(String.format("Truck: %.2f", truck.getFuelQuantity()));
        System.out.println(String.format("Bus: %.2f", bus.getFuelQuantity()));
    }
}
