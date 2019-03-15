import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumMatrixElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[][] matrix = readMatrix(reader);

        Integer sum = calcSum(matrix);

        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(sum);
    }

    private static Integer calcSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];
            }
        }

        return sum;
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
