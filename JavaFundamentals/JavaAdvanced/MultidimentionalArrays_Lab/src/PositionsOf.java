import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PositionsOf {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[][] matrix = readMatrix(reader);
        int number = Integer.parseInt(reader.readLine());
        boolean notFound = true;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == number) {
                    notFound = false;
                    System.out.printf("%d %d%n", i, j);
                }
            }
        }

        if (notFound) {
            System.out.println("not found");
        }
    }

    private static int[][] readMatrix(BufferedReader reader) throws IOException {
        String[] input = reader.readLine().split("\\s+");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            int[] line = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = line[j];
            }
        }
        return matrix;
    }
}
