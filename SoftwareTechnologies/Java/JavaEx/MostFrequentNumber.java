import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class MostFrequentNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = Arrays.stream(scan.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int max = 1;
        int mostFrequent = array[0];
        for (int i = 0; i < array.length; i++) {
            int currentNumber = array[i];
            int localMax = 1;
            for (int j = i + 1; j < array.length; j++) {
                int num = array[j];
                if (num == currentNumber) {
                    localMax++;
                }
                if (localMax > max){
                    max = localMax;
                    mostFrequent = currentNumber;
                }
            }
        }
        System.out.println(mostFrequent);
    }
}
