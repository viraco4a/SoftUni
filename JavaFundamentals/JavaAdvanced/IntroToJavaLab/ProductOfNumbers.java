import java.math.BigInteger;
import java.util.Scanner;

public class ProductOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int original = num1;
        int num2 = scanner.nextInt();
        BigInteger result = BigInteger.ONE;
        do {
            result = result.multiply(BigInteger.valueOf(num1));
            num1++;
        } while (num1 <= num2);
        System.out.printf("product[%d..%d] = %d", original, num2, result);
    }
}
