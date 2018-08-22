import java.math.BigDecimal;
import java.util.Scanner;

public class EuroTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal exchangeRate = new BigDecimal(4210500000000.0);
        double kg = Double.parseDouble(scanner.nextLine());
        BigDecimal priceInLevas = new BigDecimal(1.2 * kg);
        BigDecimal result = priceInLevas.multiply(exchangeRate);
        System.out.printf("%.2f marks", result);
    }
}