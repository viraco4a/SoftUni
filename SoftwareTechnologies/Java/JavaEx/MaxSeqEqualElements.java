import java.util.Arrays;
import java.util.Scanner;

public class MaxSeqEqualElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = Arrays.stream(scan.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int max = 1;
        int prev = array[0];
        int localmax = 1;
        int numberToPrint = prev;
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            if (current == prev){
                localmax++;
                if (localmax > max){
                    max = localmax;
                    numberToPrint = current;
                }
            }
            else{
                localmax = 1;
                prev = current;
            }
        }
        int[] result = new int[max];
        for (int i = 0; i < result.length; i++) {
            result[i] = numberToPrint;
        }
        System.out.println(Arrays
                .toString(result)
                .replaceAll("[\\[\\],]","" )
                .trim()
        );
    }
}
