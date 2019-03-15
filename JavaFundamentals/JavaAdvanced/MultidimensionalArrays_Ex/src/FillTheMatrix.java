import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FillTheMatrix {
    private static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("(, )");
        int n = Integer.parseInt(input[0]);
        String pattern = input[1];
        matrix = new int[n][n];

        if (pattern.equals("A")){
            firstPattern(n);
        } else {
            secondPattern(n);
        }

        print();
    }

    private static void print() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%s ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void secondPattern(int n) {
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    matrix[j][i] = ++num;
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    matrix[j][i] = ++num;
                }
            }
        }
    }

    private static void firstPattern(int n) {
        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[j][i] = ++num;
            }
        }
    }
}
