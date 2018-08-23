import java.util.Arrays;
import java.util.Scanner;

public class OddAndEvenPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();
        if (array.length % 2 != 0) {
            System.out.println("invalid length");
            return;
        }
        for (int i = 0; i < array.length -1; i += 2) {
            int first = array[i];
            int second = array[i + 1];
            if (first % 2 == 0 && second % 2 == 0) {
                System.out.printf("%d, %d -> both are even%n", first, second);
            } else if (first % 2 != 0 && second % 2 != 0) {
                System.out.printf("%d, %d -> both are odd%n", first, second);
            } else {
                System.out.printf("%d, %d -> different%n", first, second);
            }
        }
    }
}
