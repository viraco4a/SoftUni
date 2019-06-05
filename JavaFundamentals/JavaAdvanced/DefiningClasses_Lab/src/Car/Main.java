package Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split("\\s+");
            String make = line[0];
            String model;
            int horsePower;
            Car car = null;
            if (line.length > 1){
                model = line[1];
                horsePower = Integer.parseInt(line[2]);
                car = new Car(make, model, horsePower);
            } else {
                car = new Car(make);
            }

            cars.add(car);
        }


        cars.forEach(c -> System.out.println(c.getInfo()));
    }
}
