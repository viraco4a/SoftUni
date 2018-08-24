import java.util.Scanner;

public class XBits {
    private static int[][] matrix = new int[8][32];
    private static int counter;

    public static void main(String[] args) {
        PopulateMatrix();
        for (int col = 0; col < 30; col++) {
            for (int row = 0; row < 6; row++) {
                CheckLocalMatrix(row, col);
            }
        }
        System.out.println(counter);
    }

    private static void CheckLocalMatrix(int row, int col) {
        int first = 101;
        int second = 10;
        boolean isTrue = true;
        for (int i = row; i < row + 3; i++) {
            int local = 0;
            for (int j = col; j < col + 3; j++) {
                local *= 10;
                local += matrix[i][j];
            }
            if (i == row + 1) {
                if (local != second) {
                    isTrue = false;
                }
            } else {
                if (local != first) {
                    isTrue = false;
                }
            }
        }
        if (isTrue) {
            counter++;
        }
    }

    private static void PopulateMatrix() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 8; i++) {
            int num = scanner.nextInt();
            String strRep = Integer.toBinaryString(num);
            for (int j = 0; j < strRep.length(); j++) {
                char s = strRep.charAt(j);
                int local = 0;
                if (s == '1') {
                    local = 1;
                }
                matrix[i][(32 - strRep.length()) + j] = local;
            }
        }
    }
}
