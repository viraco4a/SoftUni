import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntersectionOfTwoMatrices {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int rows = Integer.parseInt(reader.readLine());
        int cols = Integer.parseInt(reader.readLine());

        String[][] firstMatrix = readMatrix(reader, rows, cols);
        String[][] secondMatrix = readMatrix(reader, rows, cols);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (firstMatrix[i][j].equals(secondMatrix[i][j])) {
                    sb.append(firstMatrix[i][j]).append(" ");
                } else {
                    sb.append("*").append(" ");
                }
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb.toString());
    }

    private static String[][] readMatrix(BufferedReader reader, int rows, int cols) throws IOException {
        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] line = reader.readLine().split("\\s+");

            for (int j = 0; j < cols; j++) {
                matrix[i][j] = line[j];
            }
        }
        return matrix;
    }
}
