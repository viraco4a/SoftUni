import java.util.Scanner;

public class MaximalSum {
    private static int[][] matrix;

    public static void main(String[] args) {
        ReadMatrix();
        int max = Integer.MIN_VALUE;
        int rowIndex = 0;
        int colIndex = 0;
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[0].length - 2; col++) {
                int localSum = CalcSum(row, col);
                if (localSum > max){
                    max = localSum;
                    rowIndex = row;
                    colIndex = col;
                }
            }
        }
        Print(max, rowIndex, colIndex);
    }

    private static void Print(int max, int rowIndex, int colIndex) {
        System.out.printf("Sum = %d%n", max);
        for (int row = rowIndex; row < rowIndex + 3; row++) {
            for (int col = colIndex; col < colIndex + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int CalcSum(int row, int col) {
        int sum = 0;
        for (int r = row; r < row + 3; r++) {
            for (int c = col; c < col + 3; c++) {
                sum += matrix[r][c];
            }
        }
        return sum;
    }

    private static void ReadMatrix() {
        Scanner scanner = new Scanner(System.in);
        String[] sizes = scanner.nextLine().split("\\s");
        int r = Integer.parseInt(sizes[0]);
        int c = Integer.parseInt(sizes[1]);
        matrix = new int[r][c];
        for (int row = 0; row < r; row++) {
            String[] input = scanner.nextLine().split("\\s");
            for (int col = 0; col < c; col++) {
                matrix[row][col] = Integer.parseInt(input[col]);
            }
        }
    }
}
