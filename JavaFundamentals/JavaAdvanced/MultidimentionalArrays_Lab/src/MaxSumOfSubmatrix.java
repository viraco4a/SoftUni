import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxSumOfSubmatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[][] matrix = readMatrix(reader);

        int max = Integer.MIN_VALUE;
        int row = 0;
        int col = 0;

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                int sum = matrix[i][j] + matrix[i + 1][j] + matrix[i][j + 1] + matrix[i + 1][j + 1];
                if (sum > max) {
                    max = sum;
                    row = i;
                    col = j;
                }
            }
        }

        System.out.println(matrix[row][col] + " " + matrix[row][col + 1]);
        System.out.println(matrix[row + 1][col] + " " + matrix[row + 1][col + 1]);
        System.out.println(max);
    }

    private static int[][] readMatrix(BufferedReader reader) throws IOException {
        String[] input = reader.readLine().split("(, )");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] line = Arrays.stream(reader.readLine().split("(, )"))
                    .mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = line[j];
            }
        }
        return matrix;
    }
}
