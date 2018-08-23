import java.util.Arrays;
import java.util.Scanner;

public class FirstOddOrEvenElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();
        String[] command = scanner.nextLine().split("\\s");
        int required = Integer.parseInt(command[1]);
        if ("even".equals(command[2])){
            int counter = 0;
            for (int current : array) {
                if (current % 2 == 0) {
                    counter++;
                    System.out.print(current + " ");
                }
                if (counter == required) {
                    break;
                }
            }
        } else {
            int counter = 0;
            for (int current : array) {
                if (current % 2 != 0) {
                    counter++;
                    System.out.print(current + " ");
                }
                if (counter == required) {
                    break;
                }
            }
        }
    }
}
