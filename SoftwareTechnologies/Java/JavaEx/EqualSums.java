import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();
        if (array.length == 1){
            System.out.println(0);
            return;
        }

        int left = 0;
        int right = 0;
        int index = 0;
        boolean isPossible = false;

        for (int i = 0; i < array.length; i++) {
            left = 0;
            right = 0;
            for (int j = 0; j < i; j++) {
                left += array[j];
            }
            for (int j = i + 1; j < array.length; j++) {
                right += array[j];
            }
            if (left == right) {
                isPossible = true;
                index = i;
                break;
            }
        }

        if (!isPossible) {
            System.out.println("no");
        }
        else{
            System.out.println(index);
        }



    }
}
