import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double km = Double.parseDouble(scanner.nextLine());
        String dayNight = scanner.nextLine();
        double price = 0;

        if (km >= 100){
            price = 0.06 * km;
        } else if (km >= 20) {
            price = 0.09 * km;
        } else if ("day".equals(dayNight)){
            price = 0.7 + 0.79 * km;
        } else {
            price = 0.7 + 0.9 * km;
        }

        System.out.printf("%.2f", price);
    }
}
