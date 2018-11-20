package Ferrari;

import Ferrari.contracts.Car;
import Ferrari.models.Ferrari;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.instrument.IllegalClassFormatException;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {
            String driverName = reader.readLine().trim();
            System.out.println(new Ferrari(driverName));

            String ferrariName = Ferrari.class.getSimpleName();
            String carInterface = Car.class.getSimpleName();
            boolean isCreated = Car.class.isInterface();
            if (!isCreated) {
                throw new IllegalClassFormatException("No interface created!");
            }

        } catch (IOException | IllegalClassFormatException e) {
            e.printStackTrace();
        }
    }
}