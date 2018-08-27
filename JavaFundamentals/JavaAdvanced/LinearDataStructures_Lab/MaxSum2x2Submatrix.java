import java.util.Arrays;
import java.util.Scanner;

public class MaxSum2x2Submatrix {
    private static int[][] matrix;

    public static void main(String[] args) {
        readMatrix();
        int max = Integer.MIN_VALUE;
        int indexRow = 0;
        int indexCol = 0;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[0].length - 1; col++) {
                int localSum = matrix[row][col] + matrix[row][col + 1] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1];
                if (localSum > max){
                    max = localSum;
                    indexRow = row;
                    indexCol = col;
                }
            }
        }
        Print(indexRow, indexCol, max);
    }

    private static void Print(int indexRow, int indexCol, int max) {
        for (int row = indexRow; row < indexRow + 2; row++) {
            for (int col = indexCol; col < indexCol + 2; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println(max);
    }

    private static void readMatrix() {
        Scanner scanner = new Scanner(System.in);
        int[] sizes = readArray(scanner);
        matrix = new int[sizes[0]][sizes[1]];
        for (int row = 0; row < sizes[0]; row++) {
            int[] columns = readArray(scanner);
            for (int col = 0; col < sizes[1]; col++) {
                matrix[row][col] = columns[col];
            }
        }
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
