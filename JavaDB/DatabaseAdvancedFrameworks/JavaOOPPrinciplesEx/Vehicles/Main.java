package Vehicles;

import Vehicles.models.Car;
import Vehicles.models.Truck;
import Vehicles.models.Vehicle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Vehicle> vehicles = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            for (int i = 0; i < 2; i++) {
                String[] carData = reader.readLine().split("\\s+");
                double fuelQuantity = Double.parseDouble(carData[1]);
                double fuelConsumption = Double.parseDouble(carData[2]);
                Vehicle vehicle = null;
                if (i == 0) {
                    vehicle = new Car(fuelQuantity, fuelConsumption);
                } else {
                    vehicle = new Truck(fuelQuantity, fuelConsumption);
                }
                vehicles.add(vehicle);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }

        int n = Integer.parseInt(reader.readLine());
        String message = null;
        for (int i = 0; i < n; i++) {
            try {
                String[] tokens = reader.readLine().split("\\s+");
                String command = tokens[0];
                String type = tokens[1];
                double distance = Double.parseDouble(tokens[2]);
                switch (command){
                    case "Drive":
                        if ("Car".equals(type)){
                            message = vehicles.get(0).drive(distance);
                            System.out.println(message);
                        } else {
                            message = vehicles.get(1).drive(distance);
                            System.out.println(message);
                        }
                        break;
                    case "Refuel":
                        if ("Car".equals(type)){
                            vehicles.get(0).refuel(distance);
                        } else {
                            vehicles.get(1).refuel(distance);
                        }
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }
        }

        vehicles.forEach(s -> {
            System.out.println(s.toString());
        });
    }
}
