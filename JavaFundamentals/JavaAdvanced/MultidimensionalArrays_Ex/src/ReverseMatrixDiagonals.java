import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReverseMatrixDiagonals {
    private static int[][] matrix;
    private static int startRow;
    private static int startCol;
    private static int currentRow;
    private static int currentCol;
    private static int rows;
    private static int cols;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        readMatrix(reader);
        StringBuilder sb = new StringBuilder();
        sb.append(matrix[startRow][startCol]).append(" ").append(System.lineSeparator());
        startCol--;
        currentRow = startRow;
        currentCol = startCol;
        boolean mustBreak = false;
        while (!(startCol == 0 && startRow == 0)) {
            while (true) {
                mustBreak = false;
                sb.append(matrix[currentRow][currentCol]).append(" ");
                currentRow--;
                currentCol++;

                if (currentCol == cols) {
                    startCol--;
                    currentCol = startCol;
                    if (rows == cols){
                        startRow--;
                        //TODO
                    }
                    currentRow = startRow;
                    mustBreak = true;
                }
                if (currentRow < 0) {
                    startRow--;
                    currentRow = startRow;
                    currentCol = startCol;
                    mustBreak = true;
                }
                if (mustBreak) {
                    break;
                }
            }
            sb.append(System.lineSeparator());
        }

        sb.append(matrix[0][0]);

        System.out.println(sb.toString());
    }

    private static void readMatrix(BufferedReader reader) throws IOException {
        int[] dimensions = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        cols = dimensions[1];
        rows = dimensions[0];

        matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        startRow = rows - 1;
        startCol = cols - 1;
    }
}
