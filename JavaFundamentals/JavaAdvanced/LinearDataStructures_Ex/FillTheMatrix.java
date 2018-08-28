import java.util.Scanner;

public class FillTheMatrix {
    private static int[][] matrix;
    private static int counter;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] splitted = scanner.nextLine().split(", ");
        int n = Integer.parseInt(splitted[0]);
        matrix = new int[n][n];
        counter = 1;
        if ("A".equals(splitted[1])) {
            PatternA();
        } else {
            PatternB();
        }
        Print();
    }

    private static void Print() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void PatternB() {
        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = counter++;
                }
            } else {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = counter++;
                }
            }
        }
    }

    private static void PatternA() {
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = counter++;
            }
        }
    }
}
