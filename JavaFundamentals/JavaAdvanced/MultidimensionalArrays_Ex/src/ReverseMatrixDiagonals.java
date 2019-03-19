import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReverseMatrixDiagonals {
    private static int[][] matrix;
    private static int cols;
    private static int startRow;
    private static int startCol;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        readMatrix(reader);

        StringBuilder sb = new StringBuilder();

        while (startRow != -1) {
            int row = startRow;
            int col = startCol;
            while (row >= 0 && col < cols) {
                sb.append(matrix[row--][col++]).append(" ");
            }
            sb.append(System.lineSeparator());
            startCol--;

            if (startCol < 0) {
                startCol = 0;
                startRow--;
            }
        }

        System.out.println(sb.toString());
    }

    private static void readMatrix(BufferedReader reader) throws IOException {
        String[] line = reader.readLine().split("\\s+");
        int rows = Integer.parseInt(line[0]);
        cols = Integer.parseInt(line[1]);
        matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        startRow = rows - 1;
        startCol = cols - 1;
    }
}
