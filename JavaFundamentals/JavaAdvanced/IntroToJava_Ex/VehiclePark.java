import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehiclePark {

    public static class Car {
        public String Type;
        public int SeatsNumber;

        public boolean Compare(Car other) {
            if (this.Type.equals(other.Type)) {
                if (this.SeatsNumber == other.SeatsNumber){
                    return true;
                }
            }

            return false;
        }
    }

    private static List<Car> cars = new ArrayList<>();
    private static int sold;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReadStartingCars(scanner);
        AcceptCustomers(scanner);
        PrintVehiclesLeft();
        System.out.printf("Vehicles sold: %d", sold);
    }

    private static void PrintVehiclesLeft() {
        StringBuilder  carsLeft = new StringBuilder("Vehicles left: ");
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            switch (car.Type) {
                case "Car":
                    carsLeft.append("c");
                    break;
                case "Van":
                    carsLeft.append("v");
                    break;
                case "Bus":
                    carsLeft.append("b");
                    break;
            }
            carsLeft.append(String.valueOf(car.SeatsNumber));
            if (i != cars.size() - 1){
                carsLeft.append(", ");
            }
        }
        System.out.println(carsLeft.toString());
    }

    private static void AcceptCustomers(Scanner scanner) {
        String request = scanner.nextLine();
        while (!"End of customers!".equals(request)) {
            String[] splitted = request.split("\\s");
            Car requestedCar = new Car();
            requestedCar.Type = splitted[0];
            requestedCar.SeatsNumber = Integer.parseInt(splitted[2]);
            CheckTheCar(requestedCar);
            request = scanner.nextLine();
        }
    }

    private static void CheckTheCar(Car requestedCar) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            if (car.Compare(requestedCar)) {
                int price = CalculatePrice(car);
                System.out.printf("Yes, sold for %d$%n", price);
                cars.remove(i);
                sold++;
                return;
            }
        }
        System.out.println("No");
    }

    private static int CalculatePrice(Car car) {
        switch (car.Type) {
            case "Car":
                return (int)'c' * car.SeatsNumber;
            case "Van":
                return (int)'v' * car.SeatsNumber;
            case "Bus":
                return (int)'b' * car.SeatsNumber;
        }
        return 0;
    }

    private static void ReadStartingCars(Scanner scanner) {
        String[] input = scanner.nextLine().split("\\s");
        for (String arg : input) {
            char Type = arg.charAt(0);
            int seats = Integer.parseInt(arg.replace(Type, ' ').split(" ")[1]);
            Car car = new Car();
            switch (Type) {
                case 'c':
                    car.Type = "Car";
                    break;
                case 'v':
                    car.Type = "Van";
                    break;
                case 'b':
                    car.Type = "Bus";
                    break;
            }
            car.SeatsNumber = seats;
            cars.add(car);
        }
    }
}
