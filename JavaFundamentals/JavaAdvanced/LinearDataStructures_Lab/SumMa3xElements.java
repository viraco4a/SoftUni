import java.util.Arrays;
import java.util.Scanner;

public class SumMa3xElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sizes = readArray(scanner);
        System.out.println(sizes[0]);
        System.out.println(sizes[1]);
        long sum = 0;
        int[][] matrix = new int[sizes[0]][sizes[1]];
        for (int row = 0; row < sizes[0]; row++) {
            int[] column = readArray(scanner);
            for (int col = 0; col < sizes[1]; col++) {
                matrix[row][col] = column[col];
                sum += matrix[row][col];
            }
        }
        System.out.println(sum);
    }

    private static int[] readArray(Scanner scanner) {
        int[] sizes = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        return sizes;
    }
}
