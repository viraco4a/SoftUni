import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CompareMatrices {
    private static int[][] firstMatrix;
    private static int[][] secondMatrix;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        firstMatrix = readMatrix(reader);
        secondMatrix = readMatrix(reader);

        if (areEqual()) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static boolean areEqual() {
        if (firstMatrix.length != secondMatrix.length || firstMatrix[0].length != secondMatrix[0].length) {
            return false;
        }

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[0].length; j++) {
                if (firstMatrix[i][j] != secondMatrix[i][j]){
                    return false;
                }
            }
        }
        return true;
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
