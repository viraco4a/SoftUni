import java.util.Scanner;

public class MatrixShuffling {
    private static String[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReadMatrix(scanner);
        String command = scanner.nextLine();
        while ("END".equals(command)){
            
            command = scanner.nextLine();
        }
    }

    private static void ReadMatrix(Scanner scanner) {
        String[] sizes = scanner.nextLine().split("\\s");
        int r = Integer.parseInt(sizes[0]);
        int c = Integer.parseInt(sizes[1]);
        matrix = new String[r][c];
        for (int row = 0; row < r; row++) {
            String[] input = scanner.nextLine().split("\\s");
            for (int col = 0; col < c; col++) {
                matrix[row][col] = input[col];
            }
        }
    }
}
