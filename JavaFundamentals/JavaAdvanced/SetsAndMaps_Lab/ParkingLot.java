import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Set<String> parkingLot = new HashSet<>();
        while (!"END".equals(input)){
            String[] car = input.split(", ");
            if ("IN".equals(car[0])){
                parkingLot.add(car[1]);
            } else {
                parkingLot.remove(car[1]);
            }
            input = reader.readLine();
        }
        if (parkingLot.isEmpty()){
            System.out.println("Parking Lot is Empty");
            return;
        }
        for (String car : parkingLot) {
            System.out.println(car);
        }
    }
}
