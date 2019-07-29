package HotelReservation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split("\\s+");

        Season season = Season.valueOf(tokens[2].toUpperCase());
        Discount discount = Discount.valueOf(tokens[3].toUpperCase());

        Reservation reservation = new Reservation(Double.parseDouble(tokens[0]),
                Integer.parseInt(tokens[1]), season, discount);

        System.out.printf("%.2f", PriceCalculator.calculate(reservation));
    }
}
