import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[][] matrix = readMatrix(reader);

        System.out.println();

        List<Integer> firstDiagonal = new ArrayList<>();
        List<Integer> secondDiagonal = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j) {
                    firstDiagonal.add(matrix[i][j]);
                }
                if (i + j == matrix.length - 1) {
                    secondDiagonal.add(0, matrix[i][j]);
                }
            }
        }

        firstDiagonal.forEach(e -> {
            System.out.print(e + " ");
        });
        System.out.println();
        secondDiagonal.forEach(e -> {
            System.out.print(e + " ");
        });
    }

    private static int[][] readMatrix(BufferedReader reader) throws IOException {
        String[] input = reader.readLine().split("\\s+");

        int n = Integer.parseInt(input[0]);

        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            int[] line = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = line[j];
            }
        }
        return matrix;
    }
}
