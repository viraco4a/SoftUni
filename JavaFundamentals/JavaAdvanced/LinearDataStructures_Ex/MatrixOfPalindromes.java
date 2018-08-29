import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        String[][] matrix = new String[r][c];

        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                char side = (char)('a' + row);
                char center = (char)('a' + row + col);
                String value = "" + side + center + side;
                matrix[row][col] = value;
            }
        }

        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
