import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindTheRealQueen {
    private static int[][] sums = new int[8][8];
    private static String[][] matrix;
    private static final int n = 8;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        matrix = readMatrix(reader);
        CalcSums();
        findRealQueen();
    }

    private static void findRealQueen() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j].equals("q") && sums[i][j] == 1){
                    System.out.printf("%d %d", i, j);
                    return;
                }
            }
        }
    }

    private static void CalcSums() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j].equals("q")){
                    sum(i, j);
                }
            }
        }
    }

    private static void sum(int row, int col) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == row || j == col || (row - col) == (i - j) || (row + col) == (i + j)) {
                    sums[i][j]++;
                }
            }
        }
    }

    private static String[][] readMatrix(BufferedReader reader) throws IOException {
        String[][] matrix = new String[n][n];

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split("\\s+");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = line[j];
            }
        }
        return matrix;
    }
}
