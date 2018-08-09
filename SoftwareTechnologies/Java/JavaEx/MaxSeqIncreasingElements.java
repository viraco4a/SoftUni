import java.util.Arrays;
import java.util.Scanner;

public class MaxSeqIncreasingElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = Arrays.stream(scan.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int max = 1;
        int prev = array[0];
        int localmax = 1;
        int indexToStart = 0;
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            if (current > prev){
                localmax++;
                if (localmax > max){
                    max = localmax;
                    indexToStart = i - max + 1;
                }
            }
            else{
                localmax = 1;
                prev = current;

            }
        }
        int[] result = new int[max];
        for (int i = indexToStart, j = 0; i < indexToStart + max; i++, j++) {
            result[j] = array[i];
        }
        System.out.println(Arrays
                .toString(result)
                .replaceAll("[\\[\\],]","" )
                .trim()
        );
    }

}
