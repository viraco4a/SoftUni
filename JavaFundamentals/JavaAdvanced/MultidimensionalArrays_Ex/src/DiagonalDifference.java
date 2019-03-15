import java.util.Scanner;

public class DiagonalDifference {
    private static int[][] matrix;

    public static void main(String[] args) {
        ReadMatrix();
        long primary = CalcPrimary();
        long secondary = CalcSecondary();
        long result = Math.abs(primary - secondary);
        System.out.println(result);
    }

    private static long CalcSecondary() {
        long secondary = 0;
        for (int col = matrix.length - 1, row = 0; col >= 0; col--, row++) {
            secondary += matrix[row][col];
        }
        return secondary;
    }

    private static long CalcPrimary() {
        long primary = 0;
        for (int row = 0; row < matrix.length; row++) {
            primary += matrix[row][row];
        }
        return primary;
    }

    private static void ReadMatrix() {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        matrix = new int[n][n];
        for (int row = 0; row < n; row++) {
            String[] input = scanner.nextLine().split("\\s");
            for (int col = 0; col < n; col++) {
                matrix[row][col] = Integer.parseInt(input[col]);
            }
        }
    }
}
